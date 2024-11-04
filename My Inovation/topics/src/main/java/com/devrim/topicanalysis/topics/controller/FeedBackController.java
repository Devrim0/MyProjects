package com.devrim.topicanalysis.topics.controller;

import com.devrim.topicanalysis.topics.dtos.FeedbackDTO;
import org.springframework.http.ResponseEntity;

public interface FeedBackController {
    ResponseEntity<FeedbackDTO> createFeedback(FeedbackDTO feedback);
}
