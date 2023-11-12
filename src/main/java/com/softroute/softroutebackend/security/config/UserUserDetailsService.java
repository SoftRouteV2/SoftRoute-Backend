package com.softroute.softroutebackend.security.config;

import com.softroute.softroutebackend.security.domain.model.User;
import com.softroute.softroutebackend.security.domain.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(repository.findByUsername(username));
        Optional<User> credential= Optional.ofNullable(repository.findByUsername(username));
        return credential.map(UserUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found with the name: "+ username));
    }
}
