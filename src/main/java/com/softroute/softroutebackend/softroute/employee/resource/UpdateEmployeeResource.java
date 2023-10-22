package com.softroute.softroutebackend.softroute.employee.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeResource {
    private Long employeeId;
    @NotNull
    @Column(name = "employee_dni")
    @Size(max = 8)
    private Long dni;
    @NotBlank
    @Column(name = "employee_name")
    @Size(max = 100)
    private String employeeName;
    @NotBlank
    @Column(name = "employee_password", nullable = false)
    @Size(max = 100)
    private String password;
    @NotBlank
    @Column(name = "employee_email", nullable = false)
    @Size(max = 100)
    private String email;
}
