package com.example.teamconnect.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personalDetails;
    private String cv;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
