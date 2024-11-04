package com.devrim.topicanalysis.topics.controller.impl;

import com.devrim.topicanalysis.topics.controller.ProgressController;
import com.devrim.topicanalysis.topics.dtos.ProgressDTO;
import com.devrim.topicanalysis.topics.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ProgressControllerImpl implements ProgressController {
    @Autowired
    private ProgressService progressService;

    @GetMapping
    public ResponseEntity<List<ProgressDTO>> getAllProgress() {
        List<ProgressDTO> progressList = progressService.getAllProgress();
        return ResponseEntity.ok(progressList);
    }
}
