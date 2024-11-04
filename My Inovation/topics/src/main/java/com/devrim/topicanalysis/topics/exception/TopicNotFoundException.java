package com.devrim.topicanalysis.topics.exception;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException(String topicNotFound) {
        super(topicNotFound);
    }
}
