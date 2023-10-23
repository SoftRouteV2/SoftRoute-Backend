package com.softroute.softroutebackend.softroute.destination.domain.presistence;

import com.softroute.softroutebackend.softroute.destination.domain.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Destination findByArrival(String arrival);
    Destination findByDeparture(String departure);
}
