package com.softroute.softroutebackend.softroute.shipment.domain.persistence;

import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Shipment findByCode(Long code);
    Shipment findShipmentById(Long shipmentId);
    List<Shipment> findByFreight(Double freight);
    List<Shipment> findByQuantity(Integer quantity);
    List<Shipment> findByDeliveredDate(Date deliveredDate);
    List<Shipment> findByArrivalDate(Date arrivalDate);
    @Query("SELECT s FROM Shipment s WHERE s.employee.employeeId = :employeeId")
    List<Shipment> findShipmentsByEmployeeId(@Param("employeeId") Long employeeId);
    //"param" asigna  el valor del parámetro a la consulta

    @Query("SELECT s FROM Shipment s WHERE s.sender.senderId = :senderId")
    List<Shipment> findShipmentsBySenderId(@Param("senderId") Long senderId);

}
