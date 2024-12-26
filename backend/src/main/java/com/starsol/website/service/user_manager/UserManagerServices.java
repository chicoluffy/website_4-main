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

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserManagerServices {

    @Autowired
    private DataSource dataSource;

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

     public int authenticateUser(String pUsername, String pPassword) throws FinancialSystemException {
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

    // public static String CreateSession(String pUsername, String pPassword) throws FinancialSystemException
    // {
    //     String sessionToken;

    //     sessionToken = authenticate(pUsername, pPassword);

    //     if (sessionToken == null || sessionToken.isEmpty())
    //     {
    //         throw new AuthenticationException();
    //     }

    //     return sessionToken;
    // }

    //  /**
    //  * Checks if there's a session related to 'pUsername'.
    //  *
    //  * @param pUsername Username.
    //  * @return User session token if it exists, empty string in other case.
    //  * @throws PanicException
    //  *
    //  */
    // public static String checkIfUserSessionExists(String pUsername) throws FinancialSystemException
    // {
    //     String session_tokens_keyspace;
    //     String user_keyspace;

    //     user_keyspace = StarsolRuntimeConfig.getConfig("starsol.session.user.sessions.keyspace");
    //     session_tokens_keyspace = StarsolRuntimeConfig.getConfig("starsol.session.user.session_tokens.keyspace");

    //     // first check to see if user alredy has an active session
    //     String userSession = StarsolCache.getKeyString(user_keyspace, pUsername);

    //     // entry in user session exits so check now to see if entry in session tokens exists
    //     if (userSession != null)
    //     {
    //         if (userSession.length() > 0)
    //         {
    //             String sessionToken = StarsolCache.getKeyString(session_tokens_keyspace, userSession);
    //             if (sessionToken != null)
    //             {
    //                 if (sessionToken.length() > 0)
    //                 {
    //                     refreshUserSession(userSession);
    //                     return userSession;
    //                 }
    //             }
    //         }
    //     }

    //     return "";
    // }
    
}
