package com.starsol.website.common.exceptions;

import org.springframework.http.HttpStatus;


public class StarNotFoundException extends Exception {

    private Integer errorCode;

    public StarNotFoundException(String message) {
        super(message);
        this.errorCode = 90;
    }

    public StarNotFoundException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public StarNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
        this.errorCode = 90;
    }

    public StarNotFoundException(String message, HttpStatus status, Throwable throwable) {
        super(message, throwable);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}