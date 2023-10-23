package com.softroute.softroutebackend.softroute.destination.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@With
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
