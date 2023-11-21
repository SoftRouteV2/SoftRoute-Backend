package com.softroute.softroutebackend.softroute.dth22.service;

import com.softroute.softroutebackend.shared.exception.ResourceNotFoundException;
import com.softroute.softroutebackend.shared.exception.ResourceValidationException;
import com.softroute.softroutebackend.softroute.dth22.domain.model.Dht22;
import com.softroute.softroutebackend.softroute.dth22.domain.presistence.Dht22Repository;
import com.softroute.softroutebackend.softroute.dth22.domain.service.Dht22Service;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class Dht22ServiceImp implements Dht22Service {
    private static final String ENTITY = "Dht22";
    private final Dht22Repository dht22Repository;
    private final Validator validator;
    public Dht22ServiceImp(Dht22Repository dht22Repository,Validator validator){
        this.dht22Repository=dht22Repository;
        this.validator=validator;
    }
    @Override
    public List<Dht22> getAll() {
        return dht22Repository.findAll();
    }

    @Override
    public Dht22 getById(Long dht22Id) {
        return dht22Repository.findById(dht22Id).orElseThrow(() ->
                new ResourceNotFoundException(ENTITY, dht22Id));
    }
    
    @Override
    public Dht22 create(Dht22 dht22) {
        return dht22Repository.save(dht22);
    }

    @Override
    public Dht22 update(Long dht22Id, Dht22 request) {
        Set<ConstraintViolation<Dht22>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!dht22Repository.existsById(dht22Id))
            throw new ResourceNotFoundException("Dht22", dht22Id);
        
        return dht22Repository.findById(dht22Id).map(existingDht22 -> 
            dht22Repository.save(existingDht22.withTemperature(request.getTemperature())
                .withHumidity(request.getHumidity())))
            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, dht22Id));
    }

    @Override
    public ResponseEntity<?> delete(Long dht22Id) {
        return dht22Repository.findById(dht22Id).map(
                agency -> {
                    dht22Repository.delete(agency);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, dht22Id));
    }
}
