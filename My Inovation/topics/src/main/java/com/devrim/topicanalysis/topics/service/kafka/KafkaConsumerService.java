package com.devrim.topicanalysis.topics.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my_topic", groupId = "my-group")
    public void consumeMessage(String message) {
        System.out.println("Consumed message: " + message);
        // Add business logic here
    }
}

