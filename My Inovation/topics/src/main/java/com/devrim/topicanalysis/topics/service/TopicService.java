package com.devrim.topicanalysis.topics.service;

import com.devrim.topicanalysis.topics.dtos.ContentDTO;
import com.devrim.topicanalysis.topics.dtos.TopicDTO;

import java.util.List;

public interface TopicService {
    List<TopicDTO> getAllTopics();
    TopicDTO getTopicById(Long id);
    TopicDTO createTopic(TopicDTO topic);
    ContentDTO addContentToTopic(Long id, ContentDTO contentDTO);
}
