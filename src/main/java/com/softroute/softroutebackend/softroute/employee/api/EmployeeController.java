package com.softroute.softroutebackend.softroute.employee.api;

import com.softroute.softroutebackend.softroute.employee.domain.service.EmployeeService;
import com.softroute.softroutebackend.softroute.employee.mapping.EmployeeMapper;
import com.softroute.softroutebackend.softroute.employee.resource.EmployeeResource;
import com.softroute.softroutebackend.softroute.packages.resource.PackageResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@Tag(name = "Employee", description = "Operations related to Employees")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper mapper) {
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get All Employees", description = "Get all Employees stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employees found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))})
    })
    @GetMapping
    public List<EmployeeResource> getAllEmployee() {
        return mapper.modelList(employeeService.getAll());
    }

    @Operation(summary = "Get a Employee by ID", description = "Get a Employee by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))}),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/{employeeId}")
    public EmployeeResource getEmployeeById(@PathVariable Long employeeId) {
        return mapper.toResource(employeeService.getEmployeeById(employeeId));
    }

    @Operation(summary = "Get a Employee by name", description = "Get a Employee by its name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))}),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/name/{name}")
    public EmployeeResource getEmployeeName(@PathVariable String name) {
        return mapper.toResource(employeeService.getByName(name));
    }
}
