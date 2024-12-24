package com.starsol.website.jpa.repository;


import com.starsol.website.jpa.entity.User;
import com.starsol.website.jpa.entity.UserPrivilege;
import com.starsol.website.jpa.entity.UserPrivilegeId;

import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrivilegeRepository extends JpaRepository<UserPrivilege,UserPrivilegeId>
{
    @Query("SELECT up.id.privilegeId FROM UserPrivilege up WHERE up.id.userId = :userId")
    List<UserPrivilege> findPrivilegeIdsByUserId(@Param("userId") Integer userId);
}
