package com.starsol.website.service.user_manager;

import java.sql.CallableStatement;
import java.util.Arrays;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starsol.website.common.exceptions.StarGeneralException;
import com.starsol.website.exceptions.FinancialSystemException;
import com.starsol.website.exceptions.FinancialSystemException.CODES;
import com.starsol.website.service.RedisServices;
import com.starsol.website.common.utils.SessionGenerator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserManagerServices {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RedisServices redisServices;

    private final String user_keyspace = "USER_SESSION";
    private final String session_tokens_keyspace = "USER_SESSION_TOKENS";
    private final int session_expires_seconds = 6000;

    public int authentication_check(String username, String password) {
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall("{? = call bbone.starsol_auth_authentication_check(?, ?)}")) {

            // Registrar el valor de retorno
            cs.registerOutParameter(1, Types.INTEGER);

            // Establecer los parámetros de entrada
            cs.setString(2, username);
            cs.setString(3, password);

            // Ejecutar la función
            cs.execute();

            // Devolver el valor retornado
            return cs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error ejecutando la función almacenada", e);
        }
    }

     public int authenticateUser(String pUsername, String pPassword) throws FinancialSystemException, Exception {
        int user_id = 0;
        
            user_id = authentication_check(pUsername, pPassword);       

        if (user_id <= 0) {
            return 0;
        }

        return user_id;
    }

    // public static TEntity validateApplication(String appKey) throws PanicException, BusinessLogicException {
    //     // Performs the call to the db
    //     StarsolList<TEntity> response = userModel.getUserByPassword(appKey);

    //     if (response.isEmpty()) {
    //         StarsolLog.logExternalService(Level.SEVERE, "user/error", "Login attemp: AppKey " + appKey + " is not valid");
    //         throw new BusinessLogicException(BusinessLogicException.CODES.UNDEFINED_APPLICATION);
    //     }

    //     // Extract the app data
    //     TEntity app_data = response.get(0);

    //     // Check if the application is active
    //     if (!EUserAttributes.IS_ACTIVE.getBoolean(app_data)) {
    //         StarsolLog.logExternalService(Level.SEVERE, "user/error", "Login attemp: AppKey " + appKey + " is not active");
    //         throw new BusinessLogicException(BusinessLogicException.CODES.INACTIVE_USER);
    //     }

    //     return app_data;
    // }

    public String CreateSession(String pUsername, String pPassword) throws FinancialSystemException, Exception
    {
        String sessionToken;

        sessionToken = authenticate(pUsername, pPassword);

        if (sessionToken == null || sessionToken.isEmpty())
        {
            throw new Exception("Error creating session");
        }

        return sessionToken;
    }

    private  String authenticate(String pUsername, String pPassword) throws FinancialSystemException, Exception
    {

        String retToken;
        Integer user_id;

        // first check if user has an active session already
        retToken = checkIfUserSessionExists(pUsername);

        if (!(retToken != null && !retToken.isEmpty()))
        {
            user_id = authenticateUser(pUsername, pPassword);
            // user not identified
            if (user_id == 0)
            {
                throw new Exception("User not identified");
            }

            // create session token
            retToken = user_id + "//" + new SessionGenerator().nextSessionId();

            addUserSession(retToken, pUsername);
        }

        return retToken;
    }

     /**
     * Checks if there's a session related to 'pUsername'.
     *
     * @param pUsername Username.
     * @return User session token if it exists, empty string in other case.
     * @throws PanicException
     *
     */
    public String checkIfUserSessionExists(String pUsername) throws FinancialSystemException, Exception
    {
        

        // first check to see if user alredy has an active session
        String userSession = redisServices.getKeyString(user_keyspace, pUsername);

        // entry in user session exits so check now to see if entry in session tokens exists
        if (userSession != null)
        {
            if (userSession.length() > 0)
            {
                String sessionToken = redisServices.getKeyString(session_tokens_keyspace, userSession);
                if (sessionToken != null)
                {
                    if (sessionToken.length() > 0)
                    {
                        refreshUserSession(userSession);
                        return userSession;
                    }
                }
            }
        }

        return "";
    }

    public void refreshUserSession(String pToken) throws Exception
    {
       
       redisServices.setValueWithExpiration(session_tokens_keyspace, pToken, session_expires_seconds);
       String pUsername = redisServices.getKeyString(session_tokens_keyspace, pToken);
       redisServices.setValueWithExpiration(user_keyspace, pUsername, session_expires_seconds);
 
    }

    public void addUserSession(String pSessionToken, String pUsername) throws Exception
    {
        redisServices.set(session_tokens_keyspace, pSessionToken, pUsername, session_expires_seconds);
        redisServices.set(user_keyspace, pUsername, pSessionToken, session_expires_seconds);
       
    }
    
    
}
