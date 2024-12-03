package com.starsol.website.common.exceptions;

import org.springframework.http.HttpStatus;


public class StarGeneralException extends Exception {

    private Integer errorCode;

    public StarGeneralException(String message) {
        super(message);
        this.errorCode = 99;
    }

    public StarGeneralException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public StarGeneralException(String message, Throwable throwable) {
        super(message, throwable);
        this.errorCode = 99;
    }

    public StarGeneralException(String message, HttpStatus status, Throwable throwable) {
        super(message, throwable);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}

