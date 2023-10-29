package com.softroute.softroutebackend.softroute.sender.domain.service;

import com.softroute.softroutebackend.softroute.sender.domain.model.Sender;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SenderService {
    List<Sender> getAll();
    Sender getByFullname(String fullname);
    Sender getById(Long senderId);
    Sender create(Sender sender);
    Sender update(Long senderId,Sender request);
    ResponseEntity<?> delete(Long senderId);
}
