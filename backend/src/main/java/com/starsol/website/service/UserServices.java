package com.starsol.website.service;

import org.springframework.stereotype.Service;

@Service
public class UserServices {
    //aqui hacer la interaccion con la base de datos

    // por ahora voy a quemar el user y password y token
    public boolean validateUser(String username, String password, String token) {
        if (username.equals("admin") && password.equals("admin") && token.equals("123456")) {
            return true;
        }
        return false;

    }
}
