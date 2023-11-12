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
@Tag(name = "Tracking / Shipments", description = "Read shipments by tracking Id")
@RestController
@RequestMapping("api/v1/tracking/shipments")
public class TrackingShipmentController {
    private final ShipmentService shipmentService;

    private final ShipmentMapper mapper;

    public TrackingShipmentController(ShipmentService shipmentService, ShipmentMapper mapper) {
        this.shipmentService = shipmentService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get All shipments ", description = "Get all shipments by trackingId stored in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipments found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class))})
    })
    @GetMapping("/by-tracking/{trackingId}")
    public ShipmentResource getByTrackingId(@PathVariable Long trackingId) {
        return mapper.toResource(shipmentService.getShipmentByTrackingId(trackingId));
    }

}
