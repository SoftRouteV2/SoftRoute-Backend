package com.softroute.softroutebackend.softroute.packages.api;

import com.softroute.softroutebackend.softroute.packages.domain.service.PackageService;
import com.softroute.softroutebackend.softroute.packages.mapping.PackageMapper;
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
@Tag(name = "Packages", description = "Operations related to packages")
@RestController
@RequestMapping("/api/v1/packages")
public class PackageController {
    private final PackageService packageService;
    private final PackageMapper packageMapper;

    public PackageController(PackageService packageService, PackageMapper packageMapper) {
        this.packageService = packageService;
        this.packageMapper = packageMapper;
    }

    @Operation(summary = "Get All packages", description = "Get all packages stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Packages found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))})
    })
    @GetMapping
    public List<PackageResource> getAllPackages() {
        return packageMapper.modelList(packageService.getAll());
    }

    @Operation(summary = "Get a package by ID", description = "Get a package by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))}),
            @ApiResponse(responseCode = "404", description = "Package not found")
    })
    @GetMapping("/{packageId}")
    public PackageResource getPackageById(@PathVariable Long packageId) {
        return packageMapper.toResource(packageService.getPackageById(packageId));
    }

    @Operation(summary = "Get a package by code", description = "Get a package by its code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))}),
            @ApiResponse(responseCode = "404", description = "Package not found")
    })
    @GetMapping("/code/{code}")
    public PackageResource getPackageByCode(@PathVariable Long code) {
        return packageMapper.toResource(packageService.getPackageByCode(code));
    }
}
