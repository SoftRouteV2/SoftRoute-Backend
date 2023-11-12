package com.softroute.softroutebackend.security.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthenticationResource {
    private String username;
    private String password;
}
