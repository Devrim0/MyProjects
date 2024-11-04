package com.devrim.topicanalysis.topics.controller.impl;

import com.devrim.topicanalysis.topics.controller.TopicController;
import com.devrim.topicanalysis.topics.dtos.ContentDTO;
import com.devrim.topicanalysis.topics.dtos.TopicDTO;
import com.devrim.topicanalysis.topics.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/topics")
public class TopicControllerImpl implements TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping
    public ResponseEntity<List<TopicDTO>> getAllTopics() {
        List<TopicDTO> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> getTopicById(@PathVariable Long id) {
        TopicDTO topic = topicService.getTopicById(id);
        return ResponseEntity.ok(topic);
    }

    @PostMapping
    public ResponseEntity<TopicDTO> createTopic(@RequestBody TopicDTO topicDTO) {
        TopicDTO createdTopic = topicService.createTopic(topicDTO);
        return new ResponseEntity<>(createdTopic, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TopicDTO> updateTopic(TopicDTO topicDTO) {
        return null;
    }

    @PostMapping("/{id}/contents")
    public ResponseEntity<ContentDTO> addContentToTopic(@PathVariable Long id, @RequestBody ContentDTO contentDTO) {
        ContentDTO createdContent = topicService.addContentToTopic(id, contentDTO);
        return new ResponseEntity<>(createdContent, HttpStatus.CREATED);
    }
}
