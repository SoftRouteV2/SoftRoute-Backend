package com.softroute.softroutebackend.softroute.sender.api;

import com.softroute.softroutebackend.softroute.sender.domain.service.SenderService;
import com.softroute.softroutebackend.softroute.sender.mapping.SenderMapper;
import com.softroute.softroutebackend.softroute.sender.resource.SenderResource;
import com.softroute.softroutebackend.softroute.sender.resource.CreateSenderResource;
import com.softroute.softroutebackend.softroute.sender.resource.UpdateSenderResource;
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
@Tag(name = "Sender", description = "Create, read, update and delete Sender")
@RestController
@RequestMapping(value = "api/v1/sender")
public class SenderController {
    private final SenderService senderService;
    private final SenderMapper mapper;

    public SenderController(SenderService senderService, SenderMapper mapper) {
        this.senderService = senderService;
        this.mapper = mapper;
    }
    //functional GET ALL

    @Operation(summary = "Get All serders", description = "Get all senders stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sender found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SenderResource.class))})
    })
    @GetMapping
    public List<SenderResource> getAllCompanies()
    {
        return mapper.modelList(senderService.getAll());
    }


    //functional GET BY ID
    @Operation(summary = "Get Sender by Id", description = "Get an Sender by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sender found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SenderResource.class))})
    })
    @GetMapping("{senderId}")
    public SenderResource getSenderById(@PathVariable Long senderId) {
        return mapper.toResource(senderService.getById(senderId));
    }
    //functional GET BY NAME

    @Operation(summary = "Get Sender by Code", description = "Get an Sender by Code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sender found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SenderResource.class))})
    })
    @GetMapping("name/{senderName}")
    public SenderResource getSenderByFullname(@PathVariable("senderName") String senderName) {
        return mapper.toResource(senderService.getByFullname(senderName));
    }
    //functional POST
    @Operation(summary = "Create Sender", description = "Create Sender in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sender created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SenderResource.class)
                    ))
    })
    @PostMapping
    public SenderResource createSender(@RequestBody CreateSenderResource resource){
        return mapper.toResource(senderService.create(mapper.toModel(resource)));
    }

    //function UPDATE
    @Operation(summary = "Update an Sender", description = "Update an Sender in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sender updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SenderResource.class)
                    ))
    })
    @PutMapping("/{senderId}")
    public SenderResource updateSender(@PathVariable Long senderId, @RequestBody UpdateSenderResource resource) {
        return mapper.toResource(senderService.update(senderId, mapper.toModel(resource)));
    }

    //function DELETE
    @Operation(summary = "Delete an Sender", description = "Delete an Sender from database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sender deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{senderId}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long senderId) {
        return senderService.delete(senderId);
    }
}
