package com.example.teamconnect.service;

import com.example.teamconnect.model.Message;
import com.example.teamconnect.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessagesForManager(Long managerId) {
        return messageRepository.findByManagerId(managerId);
    }

    public List<Message> getMessagesForIntern(Long internId) {
        return messageRepository.findByInternId(internId);
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }
}
