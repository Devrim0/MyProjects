package com.devrim.topicanalysis.topics.service.impl;

import com.devrim.topicanalysis.topics.dtos.ContentDTO;
import com.devrim.topicanalysis.topics.dtos.TopicDTO;
import com.devrim.topicanalysis.topics.entites.Topic;
import com.devrim.topicanalysis.topics.exception.TopicNotFoundException;
import com.devrim.topicanalysis.topics.repository.TopicRepository;
import com.devrim.topicanalysis.topics.service.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        return topics.stream()
                .map(topic -> modelMapper.map(topic, TopicDTO.class))
                .collect(Collectors.toList());
    }

    public TopicDTO getTopicById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("Topic not found"));

        // Entity -> DTO dönüşümü
        return modelMapper.map(topic, TopicDTO.class);
    }

    public TopicDTO createTopic(TopicDTO topicDTO) {
        Topic topic = modelMapper.map(topicDTO, Topic.class); // DTO -> Entity dönüşümü
        Topic savedTopic = topicRepository.save(topic);
        return modelMapper.map(savedTopic, TopicDTO.class); // Entity -> DTO dönüşümü
    }

    @Override
    public ContentDTO addContentToTopic(Long id, ContentDTO contentDTO) {
        return null;
    }
}
