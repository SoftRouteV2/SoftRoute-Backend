package com.softroute.softroutebackend.softroute.dth22.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class Dht22Resource {
    private Long id;

    private String temperature;

    private String humidity;
}
