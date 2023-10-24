package com.softroute.softroutebackend.softroute.destination.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDestinationResource {
    private Long destinationId;

    @NotBlank
    @Column(name = "departure", nullable = false)
    @Size(max = 250)
    private String departure;

    @NotBlank
    @Column(name = "arrival", nullable = false)
    @Size(max = 250)
    private String arrival;
}
