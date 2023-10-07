package com.softroute.softroutebackend.softroute.shipment.mapping;

import com.softroute.softroutebackend.shared.mapping.EnhancedModelMapper;
import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import com.softroute.softroutebackend.softroute.shipment.resource.CreateShipmentResource;
import com.softroute.softroutebackend.softroute.shipment.resource.ShipmentResource;
import com.softroute.softroutebackend.softroute.shipment.resource.UpdateShipmentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@EnableAutoConfiguration
public class ShipmentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public ShipmentResource toResource(Shipment model) { return mapper.map(model, ShipmentResource.class); }

    public Shipment toModel(CreateShipmentResource resource) { return mapper.map(resource, Shipment.class); }

    public Shipment toModel(UpdateShipmentResource resource) { return mapper.map(resource, Shipment.class); }

    public Page<ShipmentResource> modelListPage(List<Shipment> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, ShipmentResource.class), pageable, modelList.size());
    }

}
