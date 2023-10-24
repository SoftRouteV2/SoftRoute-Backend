package com.softroute.softroutebackend.softroute.tracking.mapping;

import com.softroute.softroutebackend.shared.mapping.EnhancedModelMapper;
import com.softroute.softroutebackend.softroute.tracking.domain.model.Tracking;
import com.softroute.softroutebackend.softroute.tracking.resource.TrackingResource;
import com.softroute.softroutebackend.softroute.tracking.resource.CreateTrackingResource;
import com.softroute.softroutebackend.softroute.tracking.resource.UpdateTrackingResource;
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
public class TrackingMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public TrackingResource toResource(Tracking model){
        return mapper.map(model, TrackingResource.class);
    }
    public Tracking toModel(CreateTrackingResource resource) { return mapper.map(resource, Tracking.class); }
    public Tracking toModel(UpdateTrackingResource resource) { return mapper.map(resource, Tracking.class); }
    public Page<TrackingResource> modelListPage(List<Tracking> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, TrackingResource.class), pageable, modelList.size());
    }
    public List<TrackingResource> modelList(List<Tracking> modelList){
        return mapper.mapList(modelList,TrackingResource.class);
    }
}
