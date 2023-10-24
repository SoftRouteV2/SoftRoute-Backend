package com.softroute.softroutebackend.softroute.sender.domain.presistence;

import com.softroute.softroutebackend.softroute.sender.domain.model.Sender;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SenderRepository extends JpaRepository<Sender, Long> {
    Sender findBySenderId(Long senderId);
    Sender findByDni(String dni);
    Sender findByFullname(String fullname);
}
