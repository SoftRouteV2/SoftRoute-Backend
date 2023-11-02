package com.softroute.softroutebackend.softroute.shipment.api;

import com.softroute.softroutebackend.softroute.shipment.domain.service.ShipmentService;
import com.softroute.softroutebackend.softroute.shipment.mapping.ShipmentMapper;
import com.softroute.softroutebackend.softroute.shipment.resource.ShipmentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@Tag(name = "Destinations / Shipments", description = "Read shipments by destination Id")
@RestController
@RequestMapping("api/v1/destination/shipments")
public class DestinationShipmentController {
    private final ShipmentService shipmentService;

    private final ShipmentMapper mapper;

    public DestinationShipmentController(ShipmentService shipmentService, ShipmentMapper mapper) {
        this.shipmentService = shipmentService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get All shipments ", description = "Get all shipments by destinationId stored in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipments found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class))})
    })
    @GetMapping("/by-destination/{destinationId}")
    public List<ShipmentResource> getAllByDestinationId(@PathVariable Long destinationId) {
        return mapper.modelList(shipmentService.getShipmentsByDestinationId(destinationId));
    }

    @Operation(summary = "Get All shipments ", description = "Get all shipments by departure stored in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipments found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class))})
    })
    @GetMapping("/departure/{departure}")
    public List<ShipmentResource> getAllByDeparture(@PathVariable String departure) {
        return mapper.modelList(shipmentService.getShipmentsByDeparture(departure));
    }

    @Operation(summary = "Get All shipments ", description = "Get all shipments by departure stored in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipments found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class))})
    })
    @GetMapping("/arrival/{arrival}")
    public List<ShipmentResource> getAllByArrival(@PathVariable String arrival) {
        return mapper.modelList(shipmentService.getShipmentsByArrival(arrival));
    }
}
