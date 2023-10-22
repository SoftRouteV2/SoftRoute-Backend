package com.softroute.softroutebackend.softroute.company.api;

import com.softroute.softroutebackend.softroute.company.domain.service.CompanyService;
import com.softroute.softroutebackend.softroute.company.mapping.CompanyMapper;
import com.softroute.softroutebackend.softroute.company.resource.CompanyResource;
import com.softroute.softroutebackend.softroute.company.resource.CreateCompanyResource;
import com.softroute.softroutebackend.softroute.company.resource.UpdateCompanyResource;
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
@Tag(name = "Company", description = "Create, read, update and delete Company")
@RestController
@RequestMapping(value = "api/v1/company")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper mapper;

    public CompanyController(CompanyService companyService, CompanyMapper mapper) {
        this.companyService = companyService;
        this.mapper = mapper;
    }
    //funciona GET ALL

    @Operation(summary = "Get All Companies", description = "Get all companies stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompanyResource.class))})
    })
    @GetMapping
    public List<CompanyResource> getAllCompanies()
    {
        return mapper.modelList(companyService.getAll());
    }


    //funciona GET BY ID
    @Operation(summary = "Get Company by Id", description = "Get an Company by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompanyResource.class))})
    })
    @GetMapping("{companyId}")
    public CompanyResource getCompanyById(@PathVariable Long companyId) {
        return mapper.toResource(companyService.getById(companyId));
    }
    //funciona GET BY NAME

    @Operation(summary = "Get Company by Code", description = "Get an Company by Code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompanyResource.class))})
    })
    @GetMapping("name/{companyName}")
    public CompanyResource getCompanyByName(@PathVariable("companyName") String companyName) {
        return mapper.toResource(companyService.getByName(companyName));
    }
    //funciona POST
    @Operation(summary = "Create Company", description = "Create Company in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompanyResource.class)
                    ))
    })
    @PostMapping
    public CompanyResource createCompany(@RequestBody CreateCompanyResource resource){
        return mapper.toResource(companyService.create(mapper.toModel(resource)));
    }

    //funciona UPDATE
    @Operation(summary = "Update an Company", description = "Update an Company in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompanyResource.class)
                    ))
    })
    @PutMapping("/{companyId}")
    public CompanyResource updateCompany(@PathVariable Long companyId, @RequestBody UpdateCompanyResource resource) {
        return mapper.toResource(companyService.update(companyId, mapper.toModel(resource)));
    }

    //funciona DELETE
    @Operation(summary = "Delete an Company", description = "Delete an Company from database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{companyId}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long companyId) {
        return companyService.delete(companyId);
    }
}
