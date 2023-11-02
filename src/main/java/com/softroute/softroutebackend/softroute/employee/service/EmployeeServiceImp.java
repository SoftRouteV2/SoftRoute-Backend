package com.softroute.softroutebackend.softroute.employee.service;

import com.softroute.softroutebackend.shared.exception.ResourceNotFoundException;
import com.softroute.softroutebackend.shared.exception.ResourceValidationException;
import com.softroute.softroutebackend.softroute.company.domain.presistence.CompanyRepository;
import com.softroute.softroutebackend.softroute.employee.domain.model.Employee;
import com.softroute.softroutebackend.softroute.employee.domain.persistence.EmployeeRepository;
import com.softroute.softroutebackend.softroute.employee.domain.service.EmployeeService;
import com.softroute.softroutebackend.softroute.packages.domain.model.Package;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class EmployeeServiceImp implements EmployeeService {
    private static final String ENTITY = "Employee";
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final Validator validator;
    public EmployeeServiceImp(EmployeeRepository employeeRepository, Validator validator,CompanyRepository companyRepository){
        this.employeeRepository=employeeRepository;
        this.companyRepository=companyRepository;
        this.validator=validator;
    }
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getByDNI(Long dni) {
        return employeeRepository.findByDni(dni);
    }

    @Override
    public Employee getByName(String name) {
        return employeeRepository.findByEmployeeName(name);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException(ENTITY, employeeId));
    }

    @Override
    public Employee getEmployeeByEmailAndPassword(String email, String password) {
        return employeeRepository.findByEmailAndPassword(email,password);
    }
    @Override
    public List<Employee> getEmployeeByCompanyId(Long companyId) {
        return employeeRepository.findByCompany_CompanyId(companyId);
    }
    @Override
    public Employee create(Long companyId,Employee employee) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return companyRepository.findById(companyId).map(packages -> {
            employee.setCompany(packages);
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new ResourceNotFoundException("Company", companyId));
    }
    @Override
    public Employee update(Long employeeId,Long companyId, Employee request) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!companyRepository.existsById(companyId))
            throw new ResourceNotFoundException("Company", companyId);
        return employeeRepository.findById(employeeId).map(employee ->
                        employeeRepository.save(employee.withEmployeeName(request.getEmployeeName())
                                .withEmail(request.getEmail())
                                .withPassword(request.getPassword())
                                .withDni(request.getDni())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, employeeId));
    }
    @Override
    public ResponseEntity<?> delete(Long employeeId,Long companyId) {
        Employee employeeToDelete = employeeRepository.findByEmployeeIdAndCompanyCompanyId(employeeId, companyId);
        if (employeeToDelete != null) {
            employeeRepository.delete(employeeToDelete);
            return ResponseEntity.ok().build();
        } else {
            throw new ResourceNotFoundException(ENTITY, companyId);
        }
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
