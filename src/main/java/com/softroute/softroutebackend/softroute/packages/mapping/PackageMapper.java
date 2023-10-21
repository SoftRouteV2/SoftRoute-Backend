package com.softroute.softroutebackend.softroute.packages.mapping;

import com.softroute.softroutebackend.shared.mapping.EnhancedModelMapper;
import com.softroute.softroutebackend.softroute.packages.domain.model.Package;
import com.softroute.softroutebackend.softroute.packages.resource.CreatePackageResource;
import com.softroute.softroutebackend.softroute.packages.resource.PackageResource;
import com.softroute.softroutebackend.softroute.packages.resource.UpdatePackageResource;
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
public class PackageMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public PackageResource toResource(Package model) {
        return mapper.map(model, PackageResource.class);
    }
    public Package toModel(CreatePackageResource resource) { return mapper.map(resource, Package.class); }
    public Package toModel(UpdatePackageResource resource) { return mapper.map(resource, Package.class); }
    public Page<PackageResource> modelListPage(List<Package> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, PackageResource.class), pageable, modelList.size());
    }
    public List<PackageResource> modelList(List<Package> modelList){
        return mapper.mapList(modelList,PackageResource.class);
    }
}
