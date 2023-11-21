package com.softroute.softroutebackend.softroute.tracking.domain.model;

import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@With
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tracking")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackingId;

    @NotBlank
    @Column(name = "latitude", nullable = false)
    @Size(max = 50)
    private String latitude;

    @NotNull
    @Column(name = "longitude")
    @Size(max = 50)
    private String longitude;


}
