package com.softroute.softroutebackend.softroute.company.domain.presistence;

import com.softroute.softroutebackend.softroute.company.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findCompanyByCompanyName(String companyName);
    Company findByCompanyId(Long companyId);
    Company findCompanyByPhone(Long phone);
    Company findCompanyByEmail(String email);
    Company findCompanyByEmailAndPassword(String email, String password);
}
