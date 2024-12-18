package com.starsol.website.common.dto;

import java.io.Serializable;
import lombok.Data;


@Data
public class StarResponse implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    public StarResponse() {
    }

    public StarResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
