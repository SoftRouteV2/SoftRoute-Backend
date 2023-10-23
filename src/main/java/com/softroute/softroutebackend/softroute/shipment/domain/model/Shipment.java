package com.softroute.softroutebackend.softroute.shipment.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

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
    @NotBlank
    private String description;
    @NotNull
    private Long code;
    @NotBlank
    private Double freight;
    @NotBlank
    private Integer quantity;
    @NotBlank
    private Date deliveredDate;
    @NotBlank
    private Date arrivalDate;
    @NotBlank
    private String Consignee;

    //private Employee employee_id;
    //private Sender sender_id;
    //private Consignee consignee_id;
    //private Status status_id;


}
