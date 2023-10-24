package com.softroute.softroutebackend.softroute.employee.domain.model;

import com.softroute.softroutebackend.softroute.company.domain.model.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@With
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotNull
    @Column(name = "employee_dni")
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
    //relationships
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
