package com.softroute.softroutebackend.softroute.employee.domain.persistence;


import com.softroute.softroutebackend.softroute.employee.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeName(String employeeName);
    Employee findByDni(Long dni);
    Employee findByEmailAndPassword(String email,String password);
    Employee findByEmployeeIdAndCompanyCompanyId(Long employeeId, Long companyId);
}
