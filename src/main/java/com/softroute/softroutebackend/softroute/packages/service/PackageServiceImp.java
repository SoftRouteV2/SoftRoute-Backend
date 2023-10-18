package com.softroute.softroutebackend.softroute.packages.service;

import com.softroute.softroutebackend.shared.exception.ResourceNotFoundException;
import com.softroute.softroutebackend.shared.exception.ResourceValidationException;
import com.softroute.softroutebackend.softroute.packages.domain.model.Package;
import com.softroute.softroutebackend.softroute.packages.domain.persistence.PackageRepository;
import com.softroute.softroutebackend.softroute.packages.domain.service.PackageService;
import com.softroute.softroutebackend.softroute.shipment.domain.persistence.ShipmentRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class PackageServiceImp implements PackageService {
    private static final String ENTITY = "Package";
    private final PackageRepository packageRepository;
    private final ShipmentRepository shipmentRepository;
    private final Validator validator;
    public PackageServiceImp(PackageRepository packageRepository, ShipmentRepository shipmentRepository, Validator validator) {
        this.packageRepository = packageRepository;
        this.shipmentRepository = shipmentRepository;
        this.validator = validator;
    }
    @Override
    public List<Package> getAll() {
        return packageRepository.findAll();
    }

    @Override
    public Package getPackageById(Long packageId) {
        return packageRepository.findById(packageId).orElseThrow(() ->
                new ResourceNotFoundException(ENTITY, packageId));
    }

    @Override
    public Package getPackageByCode(Long code) {
        return packageRepository.findByCode(code);
    }

    @Override
    public List<Package> getPackagesByShipmentId(Long shipmentId) {
        return packageRepository.findByShipmentId(shipmentId);
    }

    @Override
    public Package createPackage(Long shipmentId, Package newPackage) {
        Set<ConstraintViolation<Package>> violations = validator.validate(newPackage);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return shipmentRepository.findById(shipmentId).map(packages -> {
            newPackage.setShipment(packages);
            return packageRepository.save(newPackage);
        }).orElseThrow(() -> new ResourceNotFoundException("Shipment", shipmentId));
    }

    @Override
    public Package updatePackage(Long packageId, Long shipmentId, Package request) {
        Set<ConstraintViolation<Package>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!shipmentRepository.existsById(shipmentId))
            throw new ResourceNotFoundException("Shipment", shipmentId);

        return packageRepository.findById(packageId).map(existingPackage ->
                        packageRepository.save(existingPackage.withWeight(request.getWeight())
                                .withDescription(request.getDescription())
                                .withCode(request.getCode())
                                .withLength(request.getLength())
                                .withWidth(request.getWidth())
                                .withHeight(request.getHeight())))
                .orElseThrow(() -> new ResourceNotFoundException("Package", packageId));
    }

    @Override
    public ResponseEntity<?> deletePackage(Long packageId, Long shipmentId) {
        Package packageToDelete = packageRepository.findByIdAndShipmentId(packageId, shipmentId);
        if (packageToDelete != null) {
            packageRepository.delete(packageToDelete);
            return ResponseEntity.ok().build();
        } else {
            throw new ResourceNotFoundException(ENTITY, packageId);
        }
    }
}
