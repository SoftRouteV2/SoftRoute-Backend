package com.softroute.softroutebackend.softroute.company.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResource {
    private Long companyId;
    private String companyName;
    private Long ruc;
    private String password;
    private String email;
    private Long phone;
}
