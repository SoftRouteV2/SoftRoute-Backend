package com.softroute.softroutebackend.softroute.tracking.service;

import com.softroute.softroutebackend.shared.exception.ResourceNotFoundException;
import com.softroute.softroutebackend.shared.exception.ResourceValidationException;
import com.softroute.softroutebackend.softroute.shipment.domain.model.Shipment;
import com.softroute.softroutebackend.softroute.tracking.domain.model.Tracking;
import com.softroute.softroutebackend.softroute.tracking.domain.presistence.TrackingRepository;
import com.softroute.softroutebackend.softroute.tracking.domain.service.TrackingService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class TrackingServiceImp implements TrackingService {
    private static final String ENTITY = "Tracking";
    private final TrackingRepository trackingRepository;
    private final Validator validator;
    public TrackingServiceImp(TrackingRepository trackingRepository,Validator validator){
        this.trackingRepository=trackingRepository;
        this.validator=validator;
    }
    @Override
    public List<Tracking> getAll() {
        return trackingRepository.findAll();
    }

    @Override
    public Tracking getById(Long trackingId) {
        return trackingRepository.findById(trackingId).orElseThrow(() ->
                new ResourceNotFoundException(ENTITY, trackingId));
    }
    
    @Override
    public Tracking getByLatitude(String latitude) {
        return trackingRepository.findByLatitude(latitude);
    }

    @Override
    public Tracking getByLongitude(String longitude) {
        return trackingRepository.findByLongitude(longitude);
    }

    @Override
    public Tracking create(Tracking tracking) {
        return trackingRepository.save(tracking);
    }

    @Override
    public Tracking update(Long trackingId, Tracking request) {
        Set<ConstraintViolation<Tracking>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!trackingRepository.existsById(trackingId))
            throw new ResourceNotFoundException("Tracking", trackingId);
        
        return trackingRepository.findById(trackingId).map(existingTracking -> 
            trackingRepository.save(existingTracking.withLatitude(request.getLatitude())
                .withLongitude(request.getLongitude())))
            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, trackingId));
    }



    @Override
    public ResponseEntity<?> delete(Long trackingId) {
        return trackingRepository.findById(trackingId).map(
                agency -> {
                    trackingRepository.delete(agency);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, trackingId));
    }
}
