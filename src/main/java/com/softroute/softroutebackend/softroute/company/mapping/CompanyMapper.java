package com.softroute.softroutebackend.softroute.company.mapping;

import com.softroute.softroutebackend.shared.mapping.EnhancedModelMapper;
import com.softroute.softroutebackend.softroute.company.domain.model.Company;
import com.softroute.softroutebackend.softroute.company.resource.CompanyResource;
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
public class CompanyMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public CompanyResource toResource(Company model){
        return mapper.map(model, CompanyResource.class);
    }
    public Company toModel(CreatePackageResource resource) { return mapper.map(resource, Company.class); }
    public Company toModel(UpdatePackageResource resource) { return mapper.map(resource, Company.class); }
    public Page<CompanyResource> modelListPage(List<Company> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, CompanyResource.class), pageable, modelList.size());
    }
    public List<CompanyResource> modelList(List<Company> modelList){
        return mapper.mapList(modelList,CompanyResource.class);
    }
}
