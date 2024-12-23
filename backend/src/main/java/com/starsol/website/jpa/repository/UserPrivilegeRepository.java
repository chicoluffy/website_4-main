package com.starsol.website.jpa.repository;

import com.starsol.website.common.jpa.repository.BaseRepository;
import com.starsol.website.jpa.entity.User;
import com.starsol.website.jpa.entity.UserPrivilege;
import com.starsol.website.jpa.entity.UserPrivilegeId;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrivilegeRepository extends JpaRepository<UserPrivilege,UserPrivilegeId>
{
    List<UserPrivilege> findByUserId(Integer userId);
}
