package com.softroute.softroutebackend.softroute.packages.resource;

import com.softroute.softroutebackend.softroute.shipment.resource.ShipmentResource;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PackageResource {
    private Long id;
    private String description;
    private Long code;
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    //private Date packingDate;
    private ShipmentResource shipment;

}
