package com.softroute.softroutebackend.softroute.shipment.domain.service;

import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface ShipmentService {

    List<Shipment> getAll();
    Shipment getId(Long shipment_id);
    Shipment getByCode(Long code);
    List<Shipment> getByFreight(Double freight);
    List<Shipment> getByQuantity(Integer quantity);
    List<Shipment> getByDeliveredDate(Date deliveryDate);
    List<Shipment> getByArrivalDate(Date arrivalDate);
    Shipment create(Shipment shipment,Long employeeId, Long senderId,Long destinationId);
    Shipment update(Long shipment_id, Shipment request);
    ResponseEntity<?> delete(Long shipment_id);
    List<Shipment> getShipmentsByEmployeeId(Long employeeId);
    List<Shipment> getShipmentsBySenderId(Long senderId);
    List<Shipment> getShipmentsByDestinationId(Long destinationId);
    List<Shipment> getShipmentsByDeparture(String departure);
    List<Shipment> getShipmentsByArrival(String arrival);
}
