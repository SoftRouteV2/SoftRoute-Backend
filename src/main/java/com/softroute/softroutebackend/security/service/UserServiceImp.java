package com.softroute.softroutebackend.security.service;

import com.softroute.softroutebackend.security.domain.model.User;
import com.softroute.softroutebackend.security.domain.persistence.UserRepository;
import com.softroute.softroutebackend.security.domain.service.UserService;
import com.softroute.softroutebackend.shared.exception.ResourceNotFoundException;
import com.softroute.softroutebackend.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {
    private static final String ENTITY = "User";

    private final UserRepository userRepository;

    private final Validator validator;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public UserServiceImp(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }
    @Override
    public User getByCode(Long code) {
        return userRepository.findByCode(code);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        //here we encode the password, it is really important
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //here we will validate if the username is unique but later .....

        return userRepository.save(user);
    }

    @Override
    public User update(Long userId, User request) {
        Set<ConstraintViolation<User>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return userRepository.findById(userId).map(user->
                userRepository.save(user.withCode(request.getCode())
                        .withUsername(request.getUsername())
                        .withPassword(request.getPassword())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,userId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return userRepository.findById(userId).map(
                user->{
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()-> new ResourceNotFoundException(ENTITY,userId));
    }
}
