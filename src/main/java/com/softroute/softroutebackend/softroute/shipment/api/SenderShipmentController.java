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
@Tag(name = "Employee / Shipments", description = "Read shipments by employee Id")
@RestController
@RequestMapping("api/v1/senders/{senderId}/shipments")
public class SenderShipmentController {
    private final ShipmentService shipmentService;

    private final ShipmentMapper mapper;

    public SenderShipmentController(ShipmentService shipmentService, ShipmentMapper mapper) {
        this.shipmentService = shipmentService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get All shipments ", description = "Get all shipments by senderId stored in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipments found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShipmentResource.class))})
    })
    @GetMapping
    public List<ShipmentResource> getAllBySenderId(@PathVariable Long senderId) {
        return mapper.modelList(shipmentService.getShipmentsBySenderId(senderId));
    }
}
