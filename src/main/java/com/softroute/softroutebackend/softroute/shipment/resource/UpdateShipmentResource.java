package com.softroute.softroutebackend.softroute.shipment.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UpdateShipmentResource {
    private Long id;
    @NotBlank
    private String description;
    @NotNull
    private Long code;
    @NotNull
    private Double freight;
    @NotNull
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
