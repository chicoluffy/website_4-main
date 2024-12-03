package com.starsol.website.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.starsol.website.models.LoginModels;
import com.starsol.website.service.UserServices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8081")//para que se pueda comunicar con el front(Cambiar esto despues)
public class userController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/validate")
    public boolean postMethodName(@RequestBody LoginModels users) {
        return userServices.validateUser(users.getUsername(), users.getPassword(), users.getToken());
    }
    
}
