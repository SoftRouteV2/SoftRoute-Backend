package com.softroute.softroutebackend.softroute.sender.service;

import com.softroute.softroutebackend.shared.exception.ResourceNotFoundException;
import com.softroute.softroutebackend.shared.exception.ResourceValidationException;
import com.softroute.softroutebackend.softroute.sender.domain.model.Sender;
import com.softroute.softroutebackend.softroute.sender.domain.presistence.SenderRepository;
import com.softroute.softroutebackend.softroute.sender.domain.service.SenderService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class SenderServiceImp implements SenderService {
    private static final String ENTITY = "Sender";
    private final SenderRepository senderRepository;
    private final Validator validator;
    public SenderServiceImp(SenderRepository senderRepository,Validator validator){
        this.senderRepository=senderRepository;
        this.validator=validator;
    }
    @Override
    public List<Sender> getAll() {
        return senderRepository.findAll();
    }

    @Override
    public Sender getByFullname(String fullname) {
        return senderRepository.findByFullname(fullname);
    }

    @Override
    public Sender getById(Long senderId) {
        return senderRepository.findById(senderId).orElseThrow(() ->
                new ResourceNotFoundException(ENTITY, senderId));
    }

    @Override
    public Sender create(Sender sender) {
        return senderRepository.save(sender);
    }

    @Override
    public Sender update(Long senderId, Sender request) {
        Set<ConstraintViolation<Sender>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!senderRepository.existsById(senderId))
            throw new ResourceNotFoundException("Sender", senderId);
        
        
        return senderRepository.findById(senderId).map(existingSender -> 
            senderRepository.save(existingSender
            .withFullname(request.getFullname())
            .withDni(request.getDni())))
        .orElseThrow(() -> new ResourceNotFoundException("Sender", senderId));
    }

    @Override
    public ResponseEntity<?> delete(Long senderId) {
        return senderRepository.findById(senderId).map(
                agency -> {
                    senderRepository.delete(agency);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, senderId));
    }
    
}
