package com.starsol.website.service.user_manager;

import com.starsol.website.exceptions.FinancialSystemException;
import com.starsol.website.exceptions.FinancialSystemException.CODES;

public class UserManagerServices {

    public static boolean checkUserPassword(String username, String password) throws FinancialSystemException {
        if (username == null || username.isEmpty()) {
            throw new FinancialSystemException(CODES.USERNAME_EMPTY);
        }

        if (password == null || password.isEmpty()) {
            throw new FinancialSystemException(CODES.PASSWORD_EMPTY);
        }

        int user_id = 0;//StarsolSession.checkUserPassword(username, password);
        if (user_id <= 0) {
            throw new FinancialSystemException(CODES.WRONG_USERNAME_PASSWORD);
        }

        return true;
    }

    // public static int authenticateUser(String pUsername, String pPassword) throws PanicException {
    //     int user_id = 0;
    //     DataSource ds;
    //     Connection conn = null;
    //     CallableStatement ps = null;
    //     ResultSet rs = null;

    //     if (pUsername == null || pUsername.isEmpty()) {
    //         return 0;
    //     }

    //     if (pPassword == null || pPassword.isEmpty()) {
    //         return 0;
    //     }

    //     try {
    //         // get the datasource
    //         ds = StarsolDatasourceImplementation.getDatasource();
    //     } catch (Exception e) {
    //         StarsolLog.logPanic(Level.SEVERE, "can't obtain datasource " + e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
    //         throw new PanicException("Can't obtain the datasource", 90);
    //     }

    //     try {
    //         conn = ds.getConnection();
    //     } catch (Exception e) {
    //         StarsolLog.logPanic(Level.SEVERE, "can't obtain connection " + e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
    //         throw new PanicException("Can't obtain the datasource", 91);
    //     }
    //     try {
    //         ps = conn.prepareCall("{call bbone.starsol_auth_authentication_check(?, ?)}");
    //         ps.setString(1, pUsername);
    //         ps.setString(2, pPassword);
    //         rs = ps.executeQuery();
    //         rs.next();

    //         user_id = rs.getInt(1);

    //         rs.close();
    //         ps.close();
    //         conn.close();

    //     } catch (Exception ex) {
    //         StarsolLog.logDB(Level.WARNING, "Exception in prepare call and execute query " + ex.getMessage() + " " + Arrays.toString(ex.getStackTrace()));
    //         return 0;
    //     } finally {
    //         if (rs != null) {
    //             try {
    //                 rs.close();
    //             } catch (Exception ex) {
    //                 StarsolLog.logDB(Level.WARNING, "can't close recordset " + ex.getMessage() + " " + Arrays.toString(ex.getStackTrace()));
    //             }
    //         }
    //         if (ps != null) {
    //             try {
    //                 ps.close();
    //             } catch (Exception ex) {
    //                 StarsolLog.logDB(Level.WARNING, "can't close prepared statement " + ex.getMessage() + " " + Arrays.toString(ex.getStackTrace()));
    //             }
    //         }
    //         if (conn != null) {
    //             try {
    //                 conn.close();
    //             } catch (Exception ex) {
    //                 StarsolLog.logDB(Level.WARNING, "can't close connection " + ex.getMessage() + " " + Arrays.toString(ex.getStackTrace()));
    //             }
    //         }
    //     }

    //     if (user_id <= 0) {
    //         return 0;
    //     }

    //     return user_id;
    // }

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
