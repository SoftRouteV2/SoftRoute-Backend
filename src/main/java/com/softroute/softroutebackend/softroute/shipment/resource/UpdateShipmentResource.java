package com.softroute.softroutebackend.softroute.shipment.resource;

import com.softroute.softroutebackend.softroute.employee.domain.model.Employee;
import com.softroute.softroutebackend.softroute.sender.domain.model.Sender;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
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
    private Date deliveredDate;
    private Date arrivalDate;
    @NotBlank
    private String Consignee;


    //private Employee employee_id;
    //private Sender sender_id;
    //private Consignee consignee_id;
    //private Status status_id;
}
