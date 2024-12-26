package com.starsol.website.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents a privilege entity in the system.
 * 
 * <p>This entity is mapped to the "ss_privilege" table in the "bbone" schema.
 * It contains information about various privileges, including their types,
 * descriptions, and the users who created or changed them.</p>
 * 
 * <p>Fields:</p>
 * <ul>
 *   <li>{@code privilegeId} - The unique identifier for the privilege.</li>
 *   <li>{@code privilegeTypeId} - The type identifier for the privilege, default is "NONE".</li>
 *   <li>{@code description} - A description of the privilege.</li>
 *   <li>{@code createdByUserId} - The ID of the user who created the privilege.</li>
 *   <li>{@code changedOnBehalfUserId} - The ID of the user who changed the privilege on behalf of another user.</li>
 *   <li>{@code createDate} - The timestamp when the privilege was created, default is the current UTC time.</li>
 *   <li>{@code changedDate} - The timestamp when the privilege was last changed, default is the current UTC time.</li>
 *   <li>{@code createdByUser} - The user entity who created the privilege.</li>
 *   <li>{@code changedByUser} - The user entity who last changed the privilege.</li>
 * </ul>
 * 
 * <p>Relationships:</p>
 * <ul>
 *   <li>{@code createdByUser} - Many-to-one relationship with the User entity, mapped by {@code createdByUserId}.</li>
 *   <li>{@code changedByUser} - Many-to-one relationship with the User entity, mapped by {@code changedOnBehalfUserId}.</li>
 * </ul>
 * 
 * <p>Annotations:</p>
 * <ul>
 *   <li>{@code @Entity} - Specifies that this class is an entity.</li>
 *   <li>{@code @Table} - Specifies the table and schema for the entity.</li>
 *   <li>{@code @Id} - Specifies the primary key of the entity.</li>
 *   <li>{@code @Column} - Specifies the column mapping for the fields.</li>
 *   <li>{@code @ManyToOne} - Specifies a many-to-one relationship with another entity.</li>
 *   <li>{@code @JoinColumn} - Specifies the column used for joining with another entity.</li>
 * </ul>
 */
@Entity
@Table(name = "ss_privilege", schema = "bbone")
@Data
public class Privilege {
    @Id
    @Column(name = "privilege_id", nullable = false, length = 256)
    private String privilegeId;

    @Column(name = "privilege_type_id",length = 256, columnDefinition = "'NONE'")
    private String privilegeTypeId = "NONE";

    @Column(name = "description")
    private String description;

    @Column(name = "created_by_user_id", nullable = false)
    private Integer createdByUserId;

    @Column(name = "changed_on_behalf_user_id")
    private Integer changedOnBehalfUserId;

    @Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT timezone('utc',now())")
    private LocalDateTime createDate;

    @Column(name = "changed_date", columnDefinition = "TIMESTAMP DEFAULT timezone('utc',now())")
    private LocalDateTime changedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User createdByUser;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User changedByUser;
    
}
