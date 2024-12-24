package com.starsol.website.jpa.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "ss_user_privilege", schema = "bbone")
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

    public UserPrivilege(){}

    // Getters and Setters
    public UserPrivilegeId getId() {
        return id;
    }

    public void setId(UserPrivilegeId id) {
        this.id = id;
    }

    public Integer getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Integer createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Integer getChangedByUserId() {
        return changedByUserId;
    }

    public void setChangedByUserId(Integer changedByUserId) {
        this.changedByUserId = changedByUserId;
    }

    public Integer getChangedOnBehalfUserId() {
        return changedOnBehalfUserId;
    }

    public void setChangedOnBehalfUserId(Integer changedOnBehalfUserId) {
        this.changedOnBehalfUserId = changedOnBehalfUserId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(LocalDateTime changedDate) {
        this.changedDate = changedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(User createdByUser) {
        this.createdByUser = createdByUser;
    }

    public User getChangedByUser() {
        return changedByUser;
    }

    public void setChangedByUser(User changedByUser) {
        this.changedByUser = changedByUser;
    }
}
