package com.devrim.topicanalysis.topics.controller;

import com.devrim.topicanalysis.topics.dtos.ProgressDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgressController {
    ResponseEntity<List<ProgressDTO>> getAllProgress();
}
