package com.starsol.website.jpa.repository;


import com.starsol.website.jpa.entity.User;
import com.starsol.website.jpa.entity.UserPrivilege;
import com.starsol.website.jpa.entity.UserPrivilegeId;

import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

import com.starsol.website.common.jpa.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrivilegeRepository extends BaseRepository<UserPrivilege,UserPrivilegeId>
{
    @Query("SELECT up FROM UserPrivilege up WHERE up.id.privilegeId in ('V2_EXECUTE_DEPOSIT'," + 
                "'V2_EXECUTE_TRANSACTION'," + //
                "'V2_EXECUTE_TRANSACTION_CREDIT'," + //
                "'V2_EXECUTE_TRANSACTION_DEBIT'," + //
                "'V2_EXECUTE_WITHDRAWAL'," + //
                "'V2_FINANCE_ADMIN'," + //
                "'V2_FINANCE_OPERATOR') AND up.id.userId = :userId")
    List<UserPrivilege> findPrivilegeIdsByUserId(@Param("userId") Integer userId);
}
