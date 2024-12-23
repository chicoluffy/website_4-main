package com.starsol.website.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.starsol.website.jpa.entity.UserPrivilege;
import com.starsol.website.jpa.repository.UserPrivilegeRepository;

@Service
public class UserServices {
    //interaccion con redisConfig
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private UserPrivilegeRepository userPrivilegeRepository;

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
    
    public List<UserPrivilege> getUserPrivilegeIds(Integer userId) 
    {
        return userPrivilegeRepository.findPrivilegeIdsByUserId(userId);    
    }
}
