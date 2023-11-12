package com.softroute.softroutebackend.softroute.shipment.api;

import com.softroute.softroutebackend.softroute.shipment.domain.service.ShipmentService;
import com.softroute.softroutebackend.softroute.shipment.mapping.ShipmentMapper;
import com.softroute.softroutebackend.softroute.shipment.resource.CreateShipmentResource;
import com.softroute.softroutebackend.softroute.shipment.resource.ShipmentResource;
import com.softroute.softroutebackend.softroute.shipment.resource.UpdateShipmentResource;
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
@Tag(name = "Shipment", description = "Create, read, update and delete shipment")
@RestController
@RequestMapping(value = "api/v1/shipment")
public class ShipmentController {
    private final ShipmentService shipmentService;
    private final ShipmentMapper mapper;

    public ShipmentController(ShipmentService shipmentService, ShipmentMapper mapper) {
        this.shipmentService = shipmentService;
        this.mapper = mapper;
    }

    //funciona GET ALL

    @Operation(summary = "Get All Shipments", description = "Get all agencies stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipment found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class))})
    })
    @GetMapping
    public List<ShipmentResource> getAllAgencies()
    {
        return mapper.modelList(shipmentService.getAll());
    }


    //funciona GET BY ID
    @Operation(summary = "Get Shipment by Id", description = "Get an shipment by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipment found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class))})
    })
    @GetMapping("{shipmentId}")
    public ShipmentResource getShipmentById(@PathVariable Long shipmentId) {
        return mapper.toResource(shipmentService.getId(shipmentId));
    }
    //funciona GET BY NAME

    @Operation(summary = "Get Shipment by Code", description = "Get an Shipment by Code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipment found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class))})
    })
    @GetMapping("code/{shipmentCode}")
    public ShipmentResource getShipmentByCode(@PathVariable("shipmentCode") Long shipmentCode) {
        return mapper.toResource(shipmentService.getByCode(shipmentCode));
    }




    //funciona POST
    @Operation(summary = "Create Shipment", description = "Create Shipment in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipment created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class)
                    ))
    })
    @PostMapping
    public ShipmentResource createShipment(@RequestBody CreateShipmentResource resource,
                                           @RequestParam Long employeeId,
                                           @RequestParam Long senderId,
                                           @RequestParam Long destinationId,
                                           @RequestParam Long trackingId){
        return mapper.toResource(shipmentService.create(mapper.toModel(resource),employeeId,senderId,destinationId,trackingId));
    }

    //funciona UPDATE
    @Operation(summary = "Update an Shipment", description = "Update an Shipment in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipment updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class)
                    ))
    })
    @PutMapping("/{shipmentId}")
    public ShipmentResource updateShipment(@PathVariable Long shipmentId,
                                           @RequestBody UpdateShipmentResource resource) {
        return mapper.toResource(shipmentService.update(shipmentId, mapper.toModel(resource)));
    }

    //funciona DELETE
    @Operation(summary = "Delete an Shipment", description = "Delete an Shipment from database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipment deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{shipmentId}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long shipmentId) {
        return shipmentService.delete(shipmentId);
    }
}
