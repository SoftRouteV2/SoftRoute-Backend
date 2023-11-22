package com.softroute.softroutebackend.softroute.dth22.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDht22Resource {
    private Long id;

    @NotBlank
    @Column(name = "temperature")
    private String temperature;

    @NotNull
    @Column(name = "humidity")
    private String humidity;
}
