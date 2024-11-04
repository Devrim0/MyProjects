package com.devrim.topicanalysis.topics.entites;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Simulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String modelUrl; // 3D modelin veya simülasyonun URL'si
    private String config; // Simülasyon yapılandırma bilgileri
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}

