package com.starsol.website.jpa.repository;

import com.starsol.website.common.jpa.repository.BaseRepository;
import com.starsol.website.jpa.entity.User;
// import java.util.List;
    
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
}
