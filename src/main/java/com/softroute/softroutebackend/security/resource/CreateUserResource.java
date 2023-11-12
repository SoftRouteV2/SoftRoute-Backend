package com.softroute.softroutebackend.security.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResource {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotNull
    private Long code;
}
