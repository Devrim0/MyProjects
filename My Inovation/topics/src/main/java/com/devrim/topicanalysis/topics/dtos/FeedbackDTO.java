package com.devrim.topicanalysis.topics.dtos;

import lombok.Data;

@Data
public class FeedbackDTO {
    private Long id;
    private String comment;
    private int rating;

    // Getter ve Setter metodları
}