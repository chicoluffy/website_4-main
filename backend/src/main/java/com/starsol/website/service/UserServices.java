package com.starsol.website.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.starsol.website.jpa.entity.User;
import com.starsol.website.jpa.entity.UserPrivilege;
import com.starsol.website.jpa.entity.UserPrivilegeId;
import com.starsol.website.jpa.repository.UserPrivilegeRepository;
import com.starsol.website.jpa.repository.UserRepository;

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
    @Autowired
    private UserPrivilegeRepository userPrivilegeRepository;

    public List<UserPrivilege> getUserPrivileges(Integer userId)
    {
        List<UserPrivilege> privileges = userPrivilegeRepository.findByUserId(userId);
        if (privileges != null) 
        {
            return privileges;
        } 
        return new ArrayList<>();
            
    }
}
