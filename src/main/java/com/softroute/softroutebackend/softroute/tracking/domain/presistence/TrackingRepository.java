package com.softroute.softroutebackend.softroute.tracking.domain.presistence;

import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import com.softroute.softroutebackend.softroute.tracking.domain.model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    Tracking findByLatitude(String latitude);
    Tracking findByLongitude(String longitude);




}
