package com.softroute.softroutebackend.softroute.employee.api;

import com.softroute.softroutebackend.softroute.employee.domain.service.EmployeeService;
import com.softroute.softroutebackend.softroute.employee.mapping.EmployeeMapper;
import com.softroute.softroutebackend.softroute.employee.resource.CreateEmployeeResource;
import com.softroute.softroutebackend.softroute.employee.resource.EmployeeResource;
import com.softroute.softroutebackend.softroute.employee.resource.UpdateEmployeeResource;
import com.softroute.softroutebackend.softroute.packages.resource.PackageResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Tag(name = "Company / Employee", description = "Read, create, update and delete employees by company Id")
@RestController
@RequestMapping("api/v1/companies/{companyId}/employees")
public class CompanyEmployeeController {
    private final EmployeeService employeeService;

    private final EmployeeMapper mapper;

    public CompanyEmployeeController(EmployeeService employeeService, EmployeeMapper mapper) {
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get All employees ", description = "Get all employees by companyId stored in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employees found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeResource.class))})
    })
    @GetMapping
    public List<EmployeeResource> getAllByCompanyId(@PathVariable Long companyId) {
        return mapper.modelList(employeeService.getEmployeeByCompanyId(companyId));
    }

    @Operation(summary = "Create an employee", description = "Create an employee by companyId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))})
    })
    @PostMapping()
    public EmployeeResource createEmployee(@PathVariable Long companyId,
                                              @RequestBody CreateEmployeeResource resource) {
        return mapper.toResource(employeeService.create(companyId, mapper.toModel(resource)));
    }

    @Operation(summary = "Update a employee", description = "Update a employee in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee ackage updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))})
    })
    @PutMapping("{employeeId}")
    public EmployeeResource updatePackage(@PathVariable Long employeeId, @PathVariable Long companyId,
                                         @RequestBody UpdateEmployeeResource resource) {
        return mapper.toResource(employeeService.update(employeeId,companyId, mapper.toModel(resource)));
    }

    @Operation(summary = "Delete an employee", description = "Delete an employee from database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId, @PathVariable Long companyId) {
        return employeeService.delete(employeeId, companyId);
    }


}
