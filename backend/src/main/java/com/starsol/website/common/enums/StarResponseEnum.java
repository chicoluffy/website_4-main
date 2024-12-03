package com.starsol.website.common.enums;

public enum StarResponseEnum {
    SUCCESS(0),
    NOT_DATA_FOUND(80),
    ERROR(99)        
    ;
    private final int code;

    private StarResponseEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
