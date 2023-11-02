package com.softroute.softroutebackend.softroute.employee.domain.persistence;


import com.softroute.softroutebackend.softroute.employee.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeName(String employeeName);
    Employee findByDni(Long dni);
    List<Employee> findByCompany_CompanyId(Long companyId);
    Employee findByEmailAndPassword(String email,String password);
    Employee findByEmployeeIdAndCompanyCompanyId(Long employeeId, Long companyId);

    Employee findByEmail(String email);
}
