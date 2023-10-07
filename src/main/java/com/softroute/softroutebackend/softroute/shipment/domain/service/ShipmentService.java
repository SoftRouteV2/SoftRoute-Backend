package com.softroute.softroutebackend.softroute.shipment.domain.service;

import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import jakarta.xml.ws.Response;

import java.util.Date;
import java.util.List;

public interface ShipmentService {

    List<Shipment> getAll();
    Shipment getId(Long id);
    Shipment getByCode(Long code);
    List<Shipment> getByFreight(Double freight);
    List<Shipment> getByQuantity(Integer quantity);
    List<Shipment> getByDeliveredDate(Date deliveryDate);
    List<Shipment> getByArrivalDate(Date arrivalDate);
    Shipment create(Shipment shipment);
    Shipment update(Long shipment_id, Shipment shipment);
    Response<?> delete(Long shipment_id);

}
