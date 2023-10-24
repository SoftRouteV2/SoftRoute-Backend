package com.softroute.softroutebackend.softroute.destination.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DestinationResource {
    private Long destinationId;
    
    private String departure;

    private String arrival;
}
