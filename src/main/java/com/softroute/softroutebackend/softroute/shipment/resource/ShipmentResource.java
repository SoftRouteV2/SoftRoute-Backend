package com.softroute.softroutebackend.softroute.shipment.resource;

import com.softroute.softroutebackend.softroute.destination.resource.DestinationResource;
import com.softroute.softroutebackend.softroute.employee.domain.model.Employee;
import com.softroute.softroutebackend.softroute.employee.resource.EmployeeResource;
import com.softroute.softroutebackend.softroute.sender.domain.model.Sender;
import com.softroute.softroutebackend.softroute.sender.resource.SenderResource;
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
    private EmployeeResource employee;
    private SenderResource sender;
    private DestinationResource  destination;
    //private Employee employee_id;
    //private Sender sender_id;
    //private Consignee consignee_id;
    //private Status status_id;
}
