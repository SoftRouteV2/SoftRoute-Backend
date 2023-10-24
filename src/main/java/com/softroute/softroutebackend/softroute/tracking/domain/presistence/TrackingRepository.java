package com.softroute.softroutebackend.softroute.tracking.domain.presistence;

import com.softroute.softroutebackend.softroute.tracking.domain.model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    Tracking findByLatitude(String latitude);
    Tracking findByLongitude(String longitude);
}
