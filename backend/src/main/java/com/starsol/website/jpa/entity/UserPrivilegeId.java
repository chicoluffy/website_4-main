package com.starsol.website.jpa.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class UserPrivilegeId implements Serializable {
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "privilege_id")
    private String privilegeId;

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
