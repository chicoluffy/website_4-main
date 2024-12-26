package com.starsol.website.exceptions;

import com.starsol.website.common.exceptions.StarGeneralException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FinancialSystemException extends StarGeneralException{

    
    public enum CODES {
         // ----------------- COMMON ---------------------//
         INTERNAL_SERVER_ERROR                      ("SF_COMMON", 500, "Error while calling login stored procedure"),
         INVALID_USER_ID                            ("SF_ALERT", 1000, "Invalid User ID"),
         ALERT_OBJECT_MISSING                       ("SF_ALERT", 1001, "Alert object missing"),
         ALERT_MAP_MISSING                          ("SF_ALERT", 1002, "Alert map missing"),
         ALERT_KEY_MISSING                          ("SF_ALERT", 1003, "Alert key missing"),
         ALERT_VALUE_MISSING                        ("SF_ALERT", 1004, "Alert value missing"),
         ALERT_LEVEL_MISSING                        ("SF_ALERT", 1005, "Alert level missing"),
         ALERT_KEY_SHORT                            ("SF_ALERT", 1006, "Key is too short"),
         ALERT_INVALID_ID                           ("SF_ALERT", 1007, "ID is not valid"),
         ERROR_ACTION_FAILED                        ("SF_ALERT", 1008, "Action failed"),
         USER_OBJECT_MISSING                        ("SF_USER_MANAGEMENT", 5014, "User object is missing"),
         USERNAME_EMPTY                             ("SF_USER_MANAGEMENT", 5015, "Username is too short"),
         PASSWORD_EMPTY                             ("SF_USER_MANAGEMENT", 5016, "Password is too short"),
         PASSWORD_MISSING                           ("SF_USER_MANAGEMENT", 5017, "Password is missing"),
         WRONG_USERNAME_PASSWORD                    ("BL_USER_MANAGEMENT", 5033, "Username or password do not match"),
         UNDEFINED_APPLICATION                      ("BL_USER_MANAGEMENT", 5023, "None application exists with supplied key"),
         INACTIVE_USER                              ("BL_USER_MANAGEMENT", 5028, "User/application is not active");

        private final String group;    
        private final String msg;    
        private final int code;    
        
        private CODES(String group, int code, String msg) {
            this.group = group;
            this.msg = msg;
            this.code = code;
        }

        public String getGroup() {
            return group;
        }

        public String getMsg() {
            return msg;
        }

        public int getCode() {
            return code;
        }
    }

    /**
     * 
     * @param code 
     */
    public FinancialSystemException(FinancialSystemException.CODES code)
    {
        super(code.getCode(), code.getGroup()+": "+code.getMsg());
        this.writeLog(code);
    }

    /**
     * 
     * @param code 
     * @param additional 
     */
    public FinancialSystemException(FinancialSystemException.CODES code, String additional)
    {
        super(code.getCode(), code.getGroup()+": "+code.getMsg()+" "+additional);
    }

    protected final void writeLog(CODES code)
    {
        log.info(code.getMsg(), this);
    }
    
}
