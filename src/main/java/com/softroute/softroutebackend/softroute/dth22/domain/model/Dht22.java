package com.softroute.softroutebackend.softroute.dth22.domain.model;

import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;

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
@Table(name="dht22s")
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

    @OneToOne(mappedBy = "dht22")
    private Shipment shipment;
}
