package com.softroute.softroutebackend.softroute.shipment.domain.model;

import com.softroute.softroutebackend.softroute.employee.domain.model.Employee;
import com.softroute.softroutebackend.softroute.sender.domain.model.Sender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Sender sender;



}
