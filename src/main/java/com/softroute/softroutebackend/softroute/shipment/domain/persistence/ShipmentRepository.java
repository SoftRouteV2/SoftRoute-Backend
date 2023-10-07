package com.softroute.softroutebackend.softroute.shipment.domain.persistence;

import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Shipment findByCode(Long code);
    List<Shipment> findByFreight(Double freight);
    List<Shipment> findByQuantity(Integer quantity);
    List<Shipment> findByDeliveredDate(Date deliveredDate);
    List<Shipment> findByArrivalDate(Date arrivalDate);
}
