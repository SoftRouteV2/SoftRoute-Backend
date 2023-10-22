package com.softroute.softroutebackend.softroute.employee.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResource {
    private Long employeeId;
    private Long dni;
    private String employeeName;
    private String password;
    private String email;
}
