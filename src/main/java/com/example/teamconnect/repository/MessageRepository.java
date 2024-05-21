package com.example.teamconnect.repository;

import com.example.teamconnect.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByManagerId(Long managerId);
    List<Message> findByInternId(Long internId);
}
