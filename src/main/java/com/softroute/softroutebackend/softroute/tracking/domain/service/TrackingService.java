package com.softroute.softroutebackend.softroute.tracking.domain.service;

import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import com.softroute.softroutebackend.softroute.tracking.domain.model.Tracking;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TrackingService {
    List<Tracking> getAll();
    Tracking getById(Long trackingId);
    Tracking getByLatitude(String latitude);
    Tracking getByLongitude(String longitude);
    Tracking create(Tracking tracking);
    Tracking update(Long trackingId,Tracking request);

    ResponseEntity<?> delete(Long trackingId);
}
