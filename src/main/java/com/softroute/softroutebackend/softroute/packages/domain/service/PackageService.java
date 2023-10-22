package com.softroute.softroutebackend.softroute.packages.domain.service;

import com.softroute.softroutebackend.softroute.packages.domain.model.Package;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PackageService {

    List<Package> getAll();
    Package getPackageById(Long packageId);
    Package getPackageByCode(Long code);
    List<Package> getPackagesByShipmentId(Long shipmentId);
    Package createPackage(Long shipmentId, Package newPackage);
    Package updatePackage(Long packageId, Long shipmentId, Package request);
    ResponseEntity<?> deletePackage(Long packageId, Long shipmentId);
}
