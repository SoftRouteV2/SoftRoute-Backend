package com.softroute.softroutebackend.softroute.shipment.service;

import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import com.softroute.softroutebackend.softroute.shipment.domain.persistence.ShipmentRepository;
import com.softroute.softroutebackend.softroute.shipment.domain.service.ShipmentService;
import jakarta.validation.Validator;
import jakarta.xml.ws.Response;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ShipmentServiceImp implements ShipmentService {
    private static final String ENTITY = "Shipment";

    private final ShipmentRepository shipmentRepository;

    private final Validator validator;

    public ShipmentServiceImp(ShipmentRepository shipmentRepository,Validator validator) {
        this.shipmentRepository=shipmentRepository;
        this.validator=validator;
    }
    @Override
    public List<Shipment> getAll() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getId(Long id) {
        return null;
    }

    @Override
    public Shipment getByCode(Long code) {
        return shipmentRepository.findByCode(code);
    }

    @Override
    public List<Shipment> getByFreight(Double freight) {
        return shipmentRepository.findByFreight(freight);
    }

    @Override
    public List<Shipment> getByQuantity(Integer quantity) {
        return shipmentRepository.findByQuantity(quantity);
    }

    @Override
    public List<Shipment> getByDeliveredDate(Date deliveryDate) {
        return shipmentRepository.findByDeliveredDate(deliveryDate);
    }

    @Override
    public List<Shipment> getByArrivalDate(Date arrivalDate) {
        return shipmentRepository.findByArrivalDate(arrivalDate);
    }

    @Override
    public Shipment create(Shipment shipment) {
        return null;
    }

    @Override
    public Shipment update(Long shipment_id, Shipment shipment) {
        return null;
    }

    @Override
    public Response<?> delete(Long shipment_id) {
        return null;
    }
}
