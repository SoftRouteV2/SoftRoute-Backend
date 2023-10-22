package com.softroute.softroutebackend.softroute.shipment.resource;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentResource {
    private Long id;
    private String description;
    private Long code;
    private Double freight;
    private Integer quantity;
    private Date deliveredDate;
    private Date arrivalDate;
    private String Consignee;
    //private Employee employee_id;
    //private Sender sender_id;
    //private Consignee consignee_id;
    //private Status status_id;
}
