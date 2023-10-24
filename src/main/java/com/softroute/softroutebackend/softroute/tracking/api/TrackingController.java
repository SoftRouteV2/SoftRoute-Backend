package com.softroute.softroutebackend.softroute.tracking.api;

import com.softroute.softroutebackend.softroute.tracking.domain.service.TrackingService;
import com.softroute.softroutebackend.softroute.tracking.mapping.TrackingMapper;
import com.softroute.softroutebackend.softroute.tracking.resource.TrackingResource;
import com.softroute.softroutebackend.softroute.tracking.resource.CreateTrackingResource;
import com.softroute.softroutebackend.softroute.tracking.resource.UpdateTrackingResource;
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
@Tag(name = "Tracking", description = "Create, read, update and delete Tracking")
@RestController
@RequestMapping(value = "api/v1/tracking")
public class TrackingController {
    private final TrackingService trackingService;
    private final TrackingMapper mapper;

    public TrackingController(TrackingService trackingService, TrackingMapper mapper) {
        this.trackingService = trackingService;
        this.mapper = mapper;
    }

    //function GET ALL
    @Operation(summary = "Get All Trackings", description = "Get all Trackings stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracking found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackingResource.class))})
    })
    @GetMapping
    public List<TrackingResource> getAllCompanies()
    {
        return mapper.modelList(trackingService.getAll());
    }


    //function GET BY ID
    @Operation(summary = "Get Tracking by Id", description = "Get an Tracking by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracking found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackingResource.class))})
    })
    @GetMapping("{trackingId}")
    public TrackingResource getTrackingById(@PathVariable Long trackingId) {
        return mapper.toResource(trackingService.getById(trackingId));
    }

    //function GET BY LATITUDE
    @Operation(summary = "Get Tracking by Latitude", description = "Get an Tracking by Latitude")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracking found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackingResource.class))})
    })
    @GetMapping("latidude/{latidude}")
    public TrackingResource getTrackingByName(@PathVariable("latitude") String latitude) {
        return mapper.toResource(trackingService.getByLatitude(latitude));
    }

    //function GET BY LONGITUDE
    @Operation(summary = "Get Tracking by Longitude", description = "Get an Tracking by Longitude")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracking found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackingResource.class))})
    })
    @GetMapping("longitude/{longitude}")
    public TrackingResource getTrackingByLongitude(@PathVariable("longitude") String longitude) {
        return mapper.toResource(trackingService.getByLongitude(longitude));
    }


    //function POST
    @Operation(summary = "Create Tracking", description = "Create Tracking in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracking created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackingResource.class)
                    ))
    })
    @PostMapping
    public TrackingResource createTracking(@RequestBody CreateTrackingResource resource){
        return mapper.toResource(trackingService.create(mapper.toModel(resource)));
    }

    //function UPDATE
    @Operation(summary = "Update an Tracking", description = "Update a Tracking in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracking updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackingResource.class)
                    ))
    })

    @PutMapping("/{trackingId}")
    public TrackingResource updateTracking(@PathVariable Long trackingId, @RequestBody UpdateTrackingResource resource) {
        return mapper.toResource(trackingService.update(trackingId, mapper.toModel(resource)));
    }

    //function DELETE
    @Operation(summary = "Delete an Tracking", description = "Delete a Tracking from database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracking deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{trackingId}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long trackingId) {
        return trackingService.delete(trackingId);
    }
}
