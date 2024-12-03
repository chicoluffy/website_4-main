package com.starsol.website.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starsol.website.common.exceptions.StarGeneralException;
import com.starsol.website.common.web.StarBasicController;
import com.starsol.website.models.UserLoginRequest;

@RestController
@RequestMapping(value = "/home")
public class HomeController extends StarBasicController {
    
    @SuppressWarnings("rawtypes")
        @PostMapping("/Login")
        public ResponseEntity Login(
            @RequestHeader(value = "Content-Type", required = false, defaultValue = "application/json")  String contentType,    
            @RequestBody UserLoginRequest request )  {
                    // System.out.println("Request: " + SerializationUtil.obj2json(request));
                    // ResponseApi respuesta;
                    // try {
                    //     respuesta = event.createEvent(request);
                    //     return success(null);
                    // } catch (StarGeneralException e) {
                    //     return error(e.getMessage());
                    // }

                    return error("Error en el servicio");
        }
}
