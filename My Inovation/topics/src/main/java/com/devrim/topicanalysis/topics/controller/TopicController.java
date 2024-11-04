package com.devrim.topicanalysis.topics.controller;

import com.devrim.topicanalysis.topics.dtos.ContentDTO;
import com.devrim.topicanalysis.topics.dtos.TopicDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TopicController {
    ResponseEntity<List<TopicDTO>> getAllTopics();
    ResponseEntity<TopicDTO> getTopicById(Long id);
    ResponseEntity<TopicDTO> createTopic(TopicDTO topicDTO);
    ResponseEntity<TopicDTO> updateTopic(TopicDTO topicDTO);
    ResponseEntity<ContentDTO> addContentToTopic(Long id, ContentDTO contentDTO);

}
