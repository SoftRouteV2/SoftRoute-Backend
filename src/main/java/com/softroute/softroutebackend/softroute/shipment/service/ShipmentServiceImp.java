package com.softroute.softroutebackend.softroute.shipment.service;

import com.softroute.softroutebackend.shared.exception.ResourceNotFoundException;
import com.softroute.softroutebackend.shared.exception.ResourceValidationException;
import com.softroute.softroutebackend.softroute.employee.domain.model.Employee;
import com.softroute.softroutebackend.softroute.employee.domain.persistence.EmployeeRepository;
import com.softroute.softroutebackend.softroute.sender.domain.model.Sender;
import com.softroute.softroutebackend.softroute.sender.domain.presistence.SenderRepository;
import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import com.softroute.softroutebackend.softroute.shipment.domain.persistence.ShipmentRepository;
import com.softroute.softroutebackend.softroute.shipment.domain.service.ShipmentService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ShipmentServiceImp implements ShipmentService {
    private static final String ENTITY = "Shipment";

    private final ShipmentRepository shipmentRepository;
    private final EmployeeRepository employeeRepository;
    private final SenderRepository senderRepository;

    private final Validator validator;

    public ShipmentServiceImp(ShipmentRepository shipmentRepository,EmployeeRepository employeeRepository,SenderRepository senderRepository,Validator validator) {
        this.shipmentRepository=shipmentRepository;
        this.employeeRepository=employeeRepository;
        this.senderRepository=senderRepository;
        this.validator=validator;
    }
    @Override
    public List<Shipment> getAll() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getId(Long shipment_id) {
        return shipmentRepository.findById(shipment_id).orElseThrow(()->new ResourceNotFoundException(ENTITY,shipment_id));
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
    public List<Shipment> getShipmentsByEmployeeId(Long employeeId) {
        return shipmentRepository.findShipmentsByEmployeeId(employeeId);
    }
    @Override
    public List<Shipment> getShipmentsBySenderId(Long senderId) {
        return shipmentRepository.findShipmentsBySenderId(senderId);
    }
    
    @Override
    public Shipment create(Shipment shipment,Long employeeId, Long senderId) {
        Set<ConstraintViolation<Shipment>> violations = validator.validate(shipment);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        //search employee &w sender by id
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));

        Sender sender = senderRepository.findById(senderId)
                .orElseThrow(() -> new ResourceNotFoundException("Sender not found with ID: " + senderId));

        //set employee and sender to shipment
        shipment.setEmployee(employee);
        shipment.setSender(sender);

        //verify if there is an existing shipment with th same Id or code
        Shipment shipmentWithId = shipmentRepository.findShipmentById(shipment.getId());
        if (shipmentWithId != null) {
            throw new ResourceValidationException(ENTITY, "A shipment with the same ID already exists");
        }

        Shipment shipmentWithCode = shipmentRepository.findByCode(shipment.getCode());
        if (shipmentWithCode != null) {
            throw new ResourceValidationException(ENTITY, "A shipment with the same code already exists");
        }

        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment update(Long shipmentId, Shipment request) {
        return shipmentRepository.save(request);
    }

    @Override
    public ResponseEntity<?> delete(Long shipment_id) {
        return shipmentRepository.findById(shipment_id).map(
                agency -> {
                    shipmentRepository.delete(agency);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, shipment_id));
    }
}
