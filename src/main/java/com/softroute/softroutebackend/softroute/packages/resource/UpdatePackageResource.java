package com.softroute.softroutebackend.softroute.packages.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePackageResource {
    private Long id;
    @NotBlank
    private String description;
    @NotNull
    private Long code;
    @NotNull
    private Double weight;
    @NotNull
    private Double length;
    @NotNull
    private Double width;
    @NotNull
    private Double height;

}
