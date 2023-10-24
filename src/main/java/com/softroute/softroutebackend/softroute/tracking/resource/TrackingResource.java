package com.softroute.softroutebackend.softroute.tracking.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TrackingResource {
    private Long trackingId;

    private String latitude;

    private String longitude;
}
