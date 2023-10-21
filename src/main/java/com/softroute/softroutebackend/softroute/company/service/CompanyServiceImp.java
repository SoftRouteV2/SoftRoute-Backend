package com.softroute.softroutebackend.softroute.company.service;

import com.softroute.softroutebackend.shared.exception.ResourceNotFoundException;
import com.softroute.softroutebackend.shared.exception.ResourceValidationException;
import com.softroute.softroutebackend.softroute.company.domain.model.Company;
import com.softroute.softroutebackend.softroute.company.domain.presistence.CompanyRepository;
import com.softroute.softroutebackend.softroute.company.domain.service.CompanyService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public class CompanyServiceImp implements CompanyService {
    private static final String ENTITY = "Company";
    private final CompanyRepository companyRepository;
    private final Validator validator;
    public CompanyServiceImp(CompanyRepository companyRepository,Validator validator){
        this.companyRepository=companyRepository;
        this.validator=validator;
    }
    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getByName(String nameCompany) {
        return companyRepository.findCompanyByCompanyName(nameCompany);
    }

    @Override
    public Company getById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() ->
                new ResourceNotFoundException(ENTITY, companyId));
    }

    @Override
    public Company getByPhone(Long phone) {
        return companyRepository.findCompanyByPhone(phone);
    }

    @Override
    public Company getByEmailAndPassword(String email, String password) {
        return companyRepository.findCompanyByEmailAndPassword(email,password);
    }

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Long companyId, Company request) {
        Set<ConstraintViolation<Company>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!companyRepository.existsById(companyId))
            throw new ResourceNotFoundException("Company", companyId);
        return companyRepository.findById(companyId).map(existingCompany->
                companyRepository.save(existingCompany.withCompanyName(request.getCompanyName())
                        .withRuc(request.getRuc())
                        .withPhone(request.getPhone())
                        .withPassword(request.getPassword())
                        .withEmail(request.getEmail())
                )).orElseThrow(()->new ResourceNotFoundException("Company",companyId));
    }

    @Override
    public ResponseEntity<?> delete(Long companyId) {
        return companyRepository.findById(companyId).map(
                agency -> {
                    companyRepository.delete(agency);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, companyId));
    }
}
