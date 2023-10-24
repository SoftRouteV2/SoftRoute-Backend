package com.softroute.softroutebackend.softroute.tracking.resource;

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
public class CreateTrackingResource {
    @NotBlank
    @Column(name = "latitude", nullable = false)
    @Size(max = 50)
    private String latitude;

    @NotNull
    @Column(name = "longitude")
    @Size(max = 50)
    private String longitude;
}
