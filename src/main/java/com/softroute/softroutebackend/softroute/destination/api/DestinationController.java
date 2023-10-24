package com.softroute.softroutebackend.softroute.destination.api;

import com.softroute.softroutebackend.softroute.destination.domain.service.DestinationService;
import com.softroute.softroutebackend.softroute.destination.mapping.DestinationMapper;
import com.softroute.softroutebackend.softroute.destination.resource.DestinationResource;
import com.softroute.softroutebackend.softroute.destination.resource.CreateDestinationResource;
import com.softroute.softroutebackend.softroute.destination.resource.UpdateDestinationResource;
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
@Tag(name = "Destination", description = "Create, read, update and delete Destination")
@RestController
@RequestMapping(value = "api/v1/destination")
public class DestinationController {
    private final DestinationService destinationService;
    private final DestinationMapper mapper;

    public DestinationController(DestinationService destinationService, DestinationMapper mapper) {
        this.destinationService = destinationService;
        this.mapper = mapper;
    }

    //function GET ALL
    @Operation(summary = "Get All Destinations", description = "Get all destinations stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationResource.class))})
    })
    @GetMapping
    public List<DestinationResource> getAllCompanies()
    {
        return mapper.modelList(destinationService.getAll());
    }


    //function GET BY ID
    @Operation(summary = "Get Destination by Id", description = "Get an Destination by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationResource.class))})
    })
    @GetMapping("{destinationId}")
    public DestinationResource getDestinationById(@PathVariable Long destinationId) {
        return mapper.toResource(destinationService.getById(destinationId));
    }

    //function GET BY ARRIVAL
    @Operation(summary = "Get Destination by Arrival", description = "Get an Destination by Arrival")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationResource.class))})
    })
    @GetMapping("arrival/{arrival}")
    public DestinationResource getDestinationByArrival(@PathVariable("arrival") String arrival) {
        return mapper.toResource(destinationService.getByArrival(arrival));
    }

    //function GET BY DEPARTURE
    @Operation(summary = "Get Destination by Departure", description = "Get an Destination by Departure")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationResource.class))})
    })
    @GetMapping("departure/{departure}")
    public DestinationResource getDestinationByDeparture(@PathVariable("departure") String departure) {
        return mapper.toResource(destinationService.getByDeparture(departure));
    }

   
    //function POST
    @Operation(summary = "Create Destination", description = "Create Destination in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationResource.class)
                    ))
    })
    @PostMapping
    public DestinationResource createDestination(@RequestBody CreateDestinationResource resource){
        return mapper.toResource(destinationService.create(mapper.toModel(resource)));
    }

    //function UPDATE
    @Operation(summary = "Update an Destination", description = "Update an Destination in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationResource.class)
                    ))
    })
    @PutMapping("/{destinationId}")
    public DestinationResource updateDestination(@PathVariable Long destinationId, @RequestBody UpdateDestinationResource resource) {
        return mapper.toResource(destinationService.update(destinationId, mapper.toModel(resource)));
    }

    //function DELETE
    @Operation(summary = "Delete an Destination", description = "Delete an Destination from database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Destination deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{destinationId}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long destinationId) {
        return destinationService.delete(destinationId);
    }
}
