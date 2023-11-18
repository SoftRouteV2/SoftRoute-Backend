package com.softroute.softroutebackend.softroute.dth22.domain.service;

import com.softroute.softroutebackend.softroute.dth22.domain.model.Dht22;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Dht22Service {
    List<Dht22> getAll();
    Dht22 getById(Long Dht22Id);
    Dht22 create(Dht22 Dht22);
    Dht22 update(Long Dht22Id,Dht22 request);
    ResponseEntity<?> delete(Long Dht22Id);
}
