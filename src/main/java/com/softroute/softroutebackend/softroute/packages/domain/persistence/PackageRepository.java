package com.softroute.softroutebackend.softroute.packages.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.softroute.softroutebackend.softroute.packages.domain.model.Package;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
    List<Package> findByDescription(String description);
    Package findByCode(Long code);
    List<Package> findByShipmentId(Long shipmentId);
    List<Package> findByDescriptionContaining(String searchText);
    @Query("SELECT p FROM Package p WHERE p.weight > :minWeight")
    List<Package> findPackagesWithWeightGreaterThan(@Param("minWeight") Double minWeight);

    List<Package> findByWeight(Double weight);
    Package findByIdAndShipmentId(Long packageId, Long shipmentId);
}
