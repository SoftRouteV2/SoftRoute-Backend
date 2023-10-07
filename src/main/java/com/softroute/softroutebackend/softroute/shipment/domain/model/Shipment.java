package com.softroute.softroutebackend.softroute.shipment.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="shipment")
public class Shipment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Long code;
    private Double freight;
    private Integer quantity;
    private Date deliveredDate;
    private Date arrivalDate;
    //private Employee employee_id;
    //private Sender sender_id;
    //private Consignee consignee_id;
    //private Status status_id;


}
