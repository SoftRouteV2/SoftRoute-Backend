package com.softroute.softroutebackend.softroute.dth22.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@With
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tracking")
public class Dht22 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "temperature")
    private String temperature;

    @NotNull
    @Column(name = "humidity")
    private String humidity;
}
