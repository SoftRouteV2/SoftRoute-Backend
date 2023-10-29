package com.softroute.softroutebackend.softroute.employee.domain.service;

import com.softroute.softroutebackend.softroute.company.domain.model.Company;
import com.softroute.softroutebackend.softroute.employee.domain.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getByDNI(Long dni);
    Employee getByName(String name);
    List<Employee> getEmployeeByCompanyId(Long companyId);
    Employee getEmployeeById(Long employeeId);
    Employee getEmployeeByEmailAndPassword(String email, String password);
    Employee create(Long companyId, Employee employee);
    Employee update(Long employeeId,Long companyId, Employee request);
    ResponseEntity<?> delete(Long companyId, Long employeeId);
}
