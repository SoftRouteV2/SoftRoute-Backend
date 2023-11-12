package com.softroute.softroutebackend.security.mapping;

import com.softroute.softroutebackend.security.domain.model.User;
import com.softroute.softroutebackend.security.resource.CreateUserResource;
import com.softroute.softroutebackend.security.resource.UpdateUserResource;
import com.softroute.softroutebackend.security.resource.UserResource;
import com.softroute.softroutebackend.shared.mapping.EnhancedModelMapper;
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
public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model) { return mapper.map(model, UserResource.class); }

    public User toModel(CreateUserResource resource) { return mapper.map(resource, User.class); }

    public User toModel(UpdateUserResource resource) { return mapper.map(resource, User.class); }

    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }

    public List<UserResource> modelList(List<User> modelList){
        return mapper.mapList(modelList, UserResource.class);
    }
}
