package com.softroute.softroutebackend.softroute.company.domain.service;

import com.softroute.softroutebackend.softroute.company.domain.model.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {
    List<Company> getAll();
    Company getByName(String nameCompany);
    Company getById(Long companyId);
    Company getByPhone(Long phone);
    Company getByEmailAndPassword(String email,String password);
    Company create(Company company);
    Company update(Long companyId,Company request);
    ResponseEntity<?> delete(Long companyId);
}
