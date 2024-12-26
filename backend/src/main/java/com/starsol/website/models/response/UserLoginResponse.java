package com.starsol.website.models.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.starsol.website.models.Privilege;
import java.util.List;

import lombok.Data;

@Data
public class UserLoginResponse implements Serializable{

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("token")
    private String token;

    @JsonProperty("privilege")
    private List<Privilege> privilege;
    
}
