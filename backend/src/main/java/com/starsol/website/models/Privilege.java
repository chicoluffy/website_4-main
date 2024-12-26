package com.starsol.website.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Privilege implements Serializable{

    @JsonProperty("privilege_id")
    private String privilegeId;
    @JsonProperty("privilege_type_id")
    private String privilegeTypeId;
    @JsonProperty("description")
    private String description;
    
}
