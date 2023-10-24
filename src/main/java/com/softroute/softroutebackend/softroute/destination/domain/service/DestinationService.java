package com.softroute.softroutebackend.softroute.destination.domain.service;

import com.softroute.softroutebackend.softroute.destination.domain.model.Destination;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DestinationService {
    List<Destination> getAll();
    Destination getById(Long destinationId);
    Destination getByDeparture(String departure);
    Destination getByArrival(String arrival);
    Destination create(Destination destination);
    Destination update(Long destinationId,Destination request);
    ResponseEntity<?> delete(Long destinationId);
}
