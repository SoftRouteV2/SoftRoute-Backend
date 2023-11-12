package com.softroute.softroutebackend.security.domain.service;

import com.softroute.softroutebackend.security.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User getByCode(Long code);
    List<User> getAll();
    User create(User user);
    User update(Long userId, User request);
    ResponseEntity<?> delete(Long userId);
}
