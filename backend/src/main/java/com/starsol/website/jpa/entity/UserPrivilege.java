package com.starsol.website.jpa.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "ss_user_privilege", schema = "bbone")
@Data
public class UserPrivilege {

    @EmbeddedId
    private UserPrivilegeId id;

    @Column(name = "created_by_user_id", nullable = false)
    private Integer createdByUserId;

    @Column(name = "changed_by_user_id", nullable = false)
    private Integer changedByUserId;

    @Column(name = "changed_on_behalf_user_id")
    private Integer changedOnBehalfUserId;

    @Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT timezone('utc',now())")
    private LocalDateTime createdDate;

    @Column(name = "changed_date", columnDefinition = "TIMESTAMP DEFAULT timezone('utc',now())")
    private LocalDateTime changedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "privilege_id", referencedColumnName = "privilege_id", insertable = false, updatable = false)
    private Privilege privilege;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User createdByUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User changedByUser;
    
}
