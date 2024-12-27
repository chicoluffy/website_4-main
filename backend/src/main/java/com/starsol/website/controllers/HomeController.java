package com.starsol.website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starsol.website.common.exceptions.StarGeneralException;
import com.starsol.website.common.utils.SerializationUtil;
import com.starsol.website.common.web.StarBasicController;
import com.starsol.website.models.request.UserLoginRequest;
import com.starsol.website.models.response.UserLoginResponse;
import com.starsol.website.service.HomeServices;

@RestController
@RequestMapping(value = "/home")
public class HomeController extends StarBasicController {

    @Autowired
    private HomeServices homeService;
    
    @SuppressWarnings("rawtypes")
        @PostMapping("/Login")
        @CrossOrigin(origins = "http://localhost:8081")
        public ResponseEntity Login(
            @RequestHeader(value = "Content-Type", required = false, defaultValue = "application/json")  String contentType,    
            @RequestBody UserLoginRequest request )  {
                     System.out.println("Request: " + SerializationUtil.obj2json(request));
                     UserLoginResponse respuesta;
                     try {
                        respuesta = homeService.login(request);
                        return success(respuesta);
                    } catch (StarGeneralException e) {
                        return error(e.getMessage());
                    } catch (Exception e) {
                        return error(e.getMessage());
                    }

        }
}
