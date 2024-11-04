package com.devrim.topicanalysis.topics.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}


