package com.example.teamconnect.controller;

import com.example.teamconnect.model.Message;
import com.example.teamconnect.model.User;
import com.example.teamconnect.service.MessageService;
import com.example.teamconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @GetMapping("/messages")
    public List<Message> getMessages() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User manager = userService.findByUsername(username);
        return messageService.getMessagesForManager(manager.getId());
    }

    @PostMapping("/messages")
    public Message sendMessage(@RequestBody Message message) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User manager = userService.findByUsername(username);
        message.setManager(manager);
        return messageService.sendMessage(message);
    }
}

