package com.starsol.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    //interaccion con redisConfig
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void saveToken(String key, String token)
    {
        redisTemplate.opsForValue().set(key, token);
    }

    public String getToken(String key)
    {
        return (String) redisTemplate.opsForValue().get(key);
    }

    public void deleteToken(String key)
    {
        redisTemplate.delete(key);
    }

    // por ahora voy a quemar el user y password y token
    public boolean validateUser(String username, String password, String token) {
        if (username.equals("admin") && password.equals("admin") && token.equals("123456")) {
            return true;
        }
        return false;

    }
}
