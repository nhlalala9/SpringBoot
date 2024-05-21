package com.example.teamconnect.controller;

import com.example.teamconnect.model.Message;
import com.example.teamconnect.model.Profile;
import com.example.teamconnect.model.User;
import com.example.teamconnect.service.MessageService;
import com.example.teamconnect.service.ProfileService;
import com.example.teamconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intern")
public class InternController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/profile")
    public Profile getProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User intern = userService.findByUsername(username);
        return intern.getProfile();
    }

    @PostMapping("/profile")
    public Profile updateProfile(@RequestBody Profile profile) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User intern = userService.findByUsername(username);
        profile.setUser(intern);
        return profileService.saveProfile(profile);
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User intern = userService.findByUsername(username);
        return messageService.getMessagesForIntern(intern.getId());
    }

    @PostMapping("/messages")
    public Message sendMessage(@RequestBody Message message) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User intern = userService.findByUsername(username);
        message.setIntern(intern);
        return messageService.sendMessage(message);
    }
}
