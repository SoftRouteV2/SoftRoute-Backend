package com.softroute.softroutebackend.security.api;

import com.softroute.softroutebackend.security.domain.service.UserService;
import com.softroute.softroutebackend.security.mapping.UserMapper;
import com.softroute.softroutebackend.security.resource.UserResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "user")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;
    public UserController(UserService userService,UserMapper mapper){
        this.userService=userService;
        this.mapper=mapper;
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("code/{code}")
    public UserResource getByCode(@PathVariable("code") Long code, @RequestHeader("Authorization") String token) {
        System.out.println("code is working");
        return mapper.toResource(userService.getByCode(code));
    }

}
