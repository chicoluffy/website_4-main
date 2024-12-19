package com.starsol.website.jpa.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ss_user", schema = "bbone")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ss_user_user_id_seq")
    @SequenceGenerator(name = "ss_user_user_id_seq", sequenceName = "ss_user_user_id_seq", allocationSize = 1)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "username", nullable = false, length = 128)
    private String username;

    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "first_name", length = 128)
    private String firstName;

    @Column(name = "last_name", length = 128)
    private String lastName;

    @Column(name = "middle_name", length = 256)
    private String middleName;

    @Column(name = "other_names", length = 256)
    private String otherNames;

    @Column(name = "email", length = 256)
    private String email;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "full_access", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean fullAccess;

    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isActive;

    @Column(name = "trusted", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean trusted;

    @Column(name = "user_type", columnDefinition = "INTEGER DEFAULT 0")
    private Integer userType;

    @Column(name = "parameters", columnDefinition = "JSON")
    private String parameters;

    @Column(name = "tags", columnDefinition = "JSON")
    private String tags;

    @Column(name = "created_by_user_id", nullable = false)
    private Integer createdByUserId;

    @Column(name = "changed_by_user_id", nullable = false)
    private Integer changedByUserId;

    @Column(name = "changed_on_behalf_user_id")
    private Integer changedOnBehalfUserId;

    @Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT timezone('utc', now())")
    private LocalDateTime createdDate;

    @Column(name = "changed_date", columnDefinition = "TIMESTAMP DEFAULT timezone('utc', now())")
    private LocalDateTime changedDate;
}
