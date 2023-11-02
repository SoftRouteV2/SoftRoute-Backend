package com.softroute.softroutebackend.softroute.sender.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SenderResource {
    private Long senderId;
    private String fullname;
    private String dni;
}
