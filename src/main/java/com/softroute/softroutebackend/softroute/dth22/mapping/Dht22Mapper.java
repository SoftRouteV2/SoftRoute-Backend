package com.softroute.softroutebackend.softroute.dth22.mapping;

import com.softroute.softroutebackend.shared.mapping.EnhancedModelMapper;
import com.softroute.softroutebackend.softroute.dth22.domain.model.Dht22;
import com.softroute.softroutebackend.softroute.dth22.resource.CreateDht22Resource;
import com.softroute.softroutebackend.softroute.dth22.resource.Dht22Resource;
import com.softroute.softroutebackend.softroute.dth22.resource.UpdateDht22Resource;
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
public class Dht22Mapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public Dht22Resource toResource(Dht22 model){
        return mapper.map(model, Dht22Resource.class);
    }
    public Dht22 toModel(CreateDht22Resource resource) { return mapper.map(resource, Dht22.class); }
    public Dht22 toModel(UpdateDht22Resource resource) { return mapper.map(resource, Dht22.class); }
    public Page<Dht22Resource> modelListPage(List<Dht22> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, Dht22Resource.class), pageable, modelList.size());
    }
    public List<Dht22Resource> modelList(List<Dht22> modelList){
        return mapper.mapList(modelList,Dht22Resource.class);
    }
}
