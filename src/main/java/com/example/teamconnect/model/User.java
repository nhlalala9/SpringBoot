package com.example.teamconnect.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role; // manager or inter

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;


}
