package com.starsol.website.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserLoginRequest implements Serializable{
    @JsonProperty("appkey")
    private String appkey;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    
}
