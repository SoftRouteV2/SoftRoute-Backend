package com.softroute.softroutebackend.softroute.company.domain.model;

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
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    @NotBlank
    @Column(name = "company_name", nullable = false)
    @Size(max = 100)
    private String companyName;
    @NotNull
    @Column(name = "company_ruc")
    @Size(max = 8)
    private Long ruc;
    @NotBlank
    @Column(name = "company_password", nullable = false)
    @Size(max = 100)
    private String password;
    @NotBlank
    @Column(name = "company_email", nullable = false)
    @Size(max = 100)
    private String email;
    @NotNull
    @Column(name = "company_phone")
    @Size(max = 9)
    private Long phone;
}
