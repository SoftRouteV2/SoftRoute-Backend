package com.softroute.softroutebackend.softroute.sender.mapping;

import com.softroute.softroutebackend.shared.mapping.EnhancedModelMapper;
import com.softroute.softroutebackend.softroute.sender.domain.model.Sender;
import com.softroute.softroutebackend.softroute.sender.resource.SenderResource;
import com.softroute.softroutebackend.softroute.sender.resource.CreateSenderResource;
import com.softroute.softroutebackend.softroute.sender.resource.UpdateSenderResource;
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
public class SenderMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public SenderResource toResource(Sender model){
        return mapper.map(model, SenderResource.class);
    }
    public Sender toModel(CreateSenderResource resource) { return mapper.map(resource, Sender.class); }
    public Sender toModel(UpdateSenderResource resource) { return mapper.map(resource, Sender.class); }
    public Page<SenderResource> modelListPage(List<Sender> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, SenderResource.class), pageable, modelList.size());
    }
    public List<SenderResource> modelList(List<Sender> modelList){
        return mapper.mapList(modelList,SenderResource.class);
    }
}
