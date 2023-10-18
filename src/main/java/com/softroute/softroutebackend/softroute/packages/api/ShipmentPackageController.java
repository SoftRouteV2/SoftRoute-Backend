package com.softroute.softroutebackend.softroute.packages.api;

import com.softroute.softroutebackend.softroute.packages.domain.service.PackageService;
import com.softroute.softroutebackend.softroute.packages.mapping.PackageMapper;
import com.softroute.softroutebackend.softroute.packages.resource.CreatePackageResource;
import com.softroute.softroutebackend.softroute.packages.resource.PackageResource;
import com.softroute.softroutebackend.softroute.packages.resource.UpdatePackageResource;
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
@Tag(name = "Shipment / Packages", description = "Read, create, update and delete packages by shipment Id")
@RestController
@RequestMapping("api/v1/shipments/{shipmentId}/packages")
public class ShipmentPackageController {

    private final PackageService packageService;

    private final PackageMapper mapper;

    public ShipmentPackageController(PackageService packageService, PackageMapper mapper) {
        this.packageService = packageService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get All packages ", description = "Get all packages by shipmentId stored in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Packages found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))})
    })
    @GetMapping
    public List<PackageResource> getAllByAgencyId(@PathVariable Long shipmentId) {
        return mapper.modelList(packageService.getPackagesByShipmentId(shipmentId));
    }

    @Operation(summary = "Create an package", description = "Create a package by shipmentId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Packagecreated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))})
    })
    @PostMapping()
    public PackageResource createAgencyReview(@PathVariable Long shipmentId,
                                                   @RequestBody CreatePackageResource resource) {
        return mapper.toResource(packageService.createPackage(shipmentId, mapper.toModel(resource)));
    }

    @Operation(summary = "Update a package", description = "Update a package in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PackageResource.class))})
    })
    @PutMapping("{packageId}")
    public PackageResource updatePackage(@PathVariable Long packageId, @PathVariable Long shipmentId,
                                                   @RequestBody UpdatePackageResource resource) {
        return mapper.toResource(packageService.updatePackage(packageId,shipmentId, mapper.toModel(resource)));
    }

    @Operation(summary = "Delete a package", description = "Delete a package from database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{packageId}")
    public ResponseEntity<?> deletePackage(@PathVariable Long packageId, @PathVariable Long shipmentId) {
        return packageService.deletePackage(packageId, shipmentId);
    }

}
