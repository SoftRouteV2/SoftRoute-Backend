package com.softroute.softroutebackend.softroute.company.resource;

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
public class CreateCompanyResource {
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
