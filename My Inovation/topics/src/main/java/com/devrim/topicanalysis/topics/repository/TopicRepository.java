package com.devrim.topicanalysis.topics.repository;

import com.devrim.topicanalysis.topics.entites.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
