package com.softroute.softroutebackend.softroute.sender.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateSenderResource {
    @NotNull
    @Column(name = "fullname", nullable = false)
    @Size(max = 75)
    private String fullname;

    @NotBlank
    @Column(name = "dni", nullable = false)
    @Size(max = 8)
    private String dni;
}
