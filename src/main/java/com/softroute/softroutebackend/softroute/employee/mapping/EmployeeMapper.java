package com.softroute.softroutebackend.softroute.employee.mapping;

import com.softroute.softroutebackend.shared.mapping.EnhancedModelMapper;
import com.softroute.softroutebackend.softroute.employee.domain.model.Employee;
import com.softroute.softroutebackend.softroute.employee.resource.CreateEmployeeResource;
import com.softroute.softroutebackend.softroute.employee.resource.EmployeeResource;
import com.softroute.softroutebackend.softroute.employee.resource.UpdateEmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@EnableAutoConfiguration
public class EmployeeMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public EmployeeResource toResource(Employee model) { return mapper.map(model, EmployeeResource.class); }

    public Employee toModel(CreateEmployeeResource resource) { return mapper.map(resource, Employee.class); }

    public Employee toModel(UpdateEmployeeResource resource) { return mapper.map(resource, Employee.class); }

    public Page<EmployeeResource> modelListPage(List<Employee> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, EmployeeResource.class), pageable, modelList.size());
    }

    public List<EmployeeResource> modelList(List<Employee> modelList){
        return mapper.mapList(modelList,EmployeeResource.class);
    }
}
