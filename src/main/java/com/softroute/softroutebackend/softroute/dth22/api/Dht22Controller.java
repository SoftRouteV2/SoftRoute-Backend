package com.softroute.softroutebackend.softroute.dth22.api;

import com.softroute.softroutebackend.softroute.dth22.domain.service.Dht22Service;
import com.softroute.softroutebackend.softroute.dth22.mapping.Dht22Mapper;
import com.softroute.softroutebackend.softroute.dth22.resource.CreateDht22Resource;
import com.softroute.softroutebackend.softroute.dth22.resource.Dht22Resource;
import com.softroute.softroutebackend.softroute.dth22.resource.UpdateDht22Resource;
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
@Tag(name = "Dht22", description = "Create, read, update and delete Dht22")
@RestController
@RequestMapping(value = "api/v1/dht22")
public class Dht22Controller {
    private final Dht22Service dht22Service;
    private final Dht22Mapper mapper;

    public Dht22Controller(Dht22Service dht22Service, Dht22Mapper mapper) {
        this.dht22Service = dht22Service;
        this.mapper = mapper;
    }

    //function GET ALL
    @Operation(summary = "Get All Dht22s", description = "Get all Dht22s stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dht22 found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Dht22Resource.class))})
    })
    @GetMapping
    public List<Dht22Resource> getAllDht22()
    {
        return mapper.modelList(dht22Service.getAll());
    }


    //function GET BY ID
    @Operation(summary = "Get Dht22 by Id", description = "Get an Dht22 by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dht22 found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Dht22Resource.class))})
    })
    @GetMapping("{dht22Id}")
    public Dht22Resource getDht22ById(@PathVariable Long dht22Id) {
        return mapper.toResource(dht22Service.getById(dht22Id));
    }

    //function POST
    @Operation(summary = "Create Dht22", description = "Create Dht22 in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dht22 created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Dht22Resource.class)
                    ))
    })
    @PostMapping
    public Dht22Resource createDht22(@RequestBody CreateDht22Resource resource){
        return mapper.toResource(dht22Service.create(mapper.toModel(resource)));
    }

    //function UPDATE
    @Operation(summary = "Update an Dht22", description = "Update a Dht22 in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dht22 updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Dht22Resource.class)
                    ))
    })

    @PutMapping("/{dht22Id}")
    public Dht22Resource updateDht22(@PathVariable Long dht22Id, @RequestBody UpdateDht22Resource resource) {
        return mapper.toResource(dht22Service.update(dht22Id, mapper.toModel(resource)));
    }

    //function DELETE
    @Operation(summary = "Delete an Dht22", description = "Delete a Dht22 from database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dht22 deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{dht22Id}")
    public ResponseEntity<?> deleteDht22(@PathVariable Long dht22Id) {
        return dht22Service.delete(dht22Id);
    }
}
