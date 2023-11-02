package com.softroute.softroutebackend.softroute.destination.service;

import com.softroute.softroutebackend.shared.exception.ResourceNotFoundException;
import com.softroute.softroutebackend.shared.exception.ResourceValidationException;
import com.softroute.softroutebackend.softroute.destination.domain.model.Destination;
import com.softroute.softroutebackend.softroute.destination.domain.presistence.DestinationRepository;
import com.softroute.softroutebackend.softroute.destination.domain.service.DestinationService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class DestinationServiceImp implements DestinationService {
    private static final String ENTITY = "Destination";
    private final DestinationRepository destinationRepository;
    private final Validator validator;
    public DestinationServiceImp(DestinationRepository destinationRepository,Validator validator){
        this.destinationRepository=destinationRepository;
        this.validator=validator;
    }
    @Override
    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }

    
    @Override
    public Destination getById(Long destinationId) {
        return destinationRepository.findById(destinationId).orElseThrow(() ->
        new ResourceNotFoundException(ENTITY, destinationId));
    }
    
    @Override
    public Destination getByDeparture(String departure) {
        return destinationRepository.findByDeparture(departure);
    }
    @Override
    public Destination getByArrival(String arrival) {
        return destinationRepository.findByArrival(arrival);
    }

    @Override
    public Destination create(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public Destination update(Long destinationId, Destination request) {
        Set<ConstraintViolation<Destination>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!destinationRepository.existsById(destinationId))
            throw new ResourceNotFoundException("Destination", destinationId);

        return destinationRepository.findById(destinationId).map(destination ->
                        destinationRepository.save(destination.withArrival(request.getArrival())
                                .withDeparture(request.getDeparture())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, destinationId));

    }

    @Override
    public ResponseEntity<?> delete(Long destinationId) {
        return destinationRepository.findById(destinationId).map(
                agency -> {
                    destinationRepository.delete(agency);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, destinationId));
    }
}
