package com.devrim.topicanalysis.topics.entites;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // text, video, simulation
    private String url;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}