package com.starsol.website.common.web;

import com.starsol.website.common.dto.StarResponse;
import com.starsol.website.common.enums.StarResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
public abstract class StarBasicController {

    /**
     * Respuesta standard para servicios Rest
     *
     * @param code
     * @param message
     * @param data
     * @param status
     * @return
     */
    public ResponseEntity<StarResponse> response(Integer code, String message, Object data, HttpStatus status) {
        StarResponse mresponse = new StarResponse();
        mresponse.setCode(code);
        mresponse.setMessage(message);
        mresponse.setData(data);
        return new ResponseEntity<>(mresponse, status);
    }

    public ResponseEntity<StarResponse> success(Object data) {
        return response(StarResponseEnum.SUCCESS.getCode(), "", data, HttpStatus.OK);
    }

    public ResponseEntity<StarResponse> success() {
        return response(StarResponseEnum.SUCCESS.getCode(), "", null, HttpStatus.OK);
    }

    public ResponseEntity<StarResponse> error(String message) {
        return response(StarResponseEnum.ERROR.getCode(), message, null, HttpStatus.BAD_REQUEST);
    }
}
