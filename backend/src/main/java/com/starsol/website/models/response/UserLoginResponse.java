package com.starsol.website.models.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserLoginResponse implements Serializable{

    @JsonProperty("token")
    private String token;
    
}
