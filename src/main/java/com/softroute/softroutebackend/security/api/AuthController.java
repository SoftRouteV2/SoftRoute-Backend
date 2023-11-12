package com.softroute.softroutebackend.security.api;

import com.softroute.softroutebackend.security.domain.service.UserService;
import com.softroute.softroutebackend.security.mapping.UserMapper;
import com.softroute.softroutebackend.security.resource.CreateAuthenticationResource;
import com.softroute.softroutebackend.security.resource.CreateUserResource;
import com.softroute.softroutebackend.security.resource.UserResource;
import com.softroute.softroutebackend.security.service.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "auth")
public class AuthController {
    private final UserService userService;
    private final UserMapper mapper;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    //the code is done i've tested this before and it works
    //but for the next video im gonna test this back in postman see u
    public AuthController(UserService userService,UserMapper mapper){
        this.userService=userService;
        this.mapper=mapper;
    }

    @Transactional
    @PostMapping("/register")
    public UserResource createAgency(@RequestBody CreateUserResource resource){
        System.out.println("Enter?");
        return mapper.toResource(userService.create(mapper.toModel(resource)));
    }
    //JWT IMPLEMENTATION
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody CreateAuthenticationResource authRequest) {
        System.out.println("Sera?"+authRequest.getUsername()+authRequest.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            System.out.println("holaaa");

            if (authentication.isAuthenticated()) {
                System.out.println("no way?");
                return jwtService.generateToken(authRequest.getUsername());
            } else {
                throw new UsernameNotFoundException("invalid user request !");
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, imprimir un mensaje de error
            e.printStackTrace();
            throw new UsernameNotFoundException("Error during authentication");
        }

    }

}
