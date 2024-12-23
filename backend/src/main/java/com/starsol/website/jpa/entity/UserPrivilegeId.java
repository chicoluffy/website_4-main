package com.starsol.website.jpa.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserPrivilegeId implements Serializable {
    private Integer userId;
    private String privilegeId;

    public UserPrivilegeId() {}
    public UserPrivilegeId(Integer userId, String privilegeId) {
        this.userId = userId;
        this.privilegeId = privilegeId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getPrivilegeId() {
        return privilegeId;
    }
    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserPrivilegeId that = (UserPrivilegeId) obj;
        return Objects.equals(userId, that.userId) && 
        Objects.equals(privilegeId, that.privilegeId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userId, privilegeId);
    }

}
