package com.softroute.softroutebackend.security.domain.persistence;

import com.softroute.softroutebackend.security.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByCode(Long code);
    User findByUsername(String username);
}
