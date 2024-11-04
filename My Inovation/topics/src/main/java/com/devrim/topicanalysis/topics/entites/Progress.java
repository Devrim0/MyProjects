package com.devrim.topicanalysis.topics.entites;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double completionRate; // İlerleme oranı
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}