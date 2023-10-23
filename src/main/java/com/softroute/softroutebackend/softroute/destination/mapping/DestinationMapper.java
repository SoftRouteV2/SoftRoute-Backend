package com.softroute.softroutebackend.softroute.destination.mapping;

import com.softroute.softroutebackend.shared.mapping.EnhancedModelMapper;
import com.softroute.softroutebackend.softroute.destination.domain.model.Destination;
import com.softroute.softroutebackend.softroute.destination.resource.DestinationResource;
import com.softroute.softroutebackend.softroute.destination.resource.CreateDestinationResource;
import com.softroute.softroutebackend.softroute.destination.resource.UpdateDestinationResource;
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
public class DestinationMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public DestinationResource toResource(Destination model){
        return mapper.map(model, DestinationResource.class);
    }
    public Destination toModel(CreateDestinationResource resource) { return mapper.map(resource, Destination.class); }
    public Destination toModel(UpdateDestinationResource resource) { return mapper.map(resource, Destination.class); }
    public Page<DestinationResource> modelListPage(List<Destination> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, DestinationResource.class), pageable, modelList.size());
    }
    public List<DestinationResource> modelList(List<Destination> modelList){
        return mapper.mapList(modelList,DestinationResource.class);
    }
}
