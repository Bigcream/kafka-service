package com.example.demokafka.kafka;

import com.example.demokafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "demoTopic", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));

    }

    @KafkaListener(topics = "demoTopicJson", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Message received -> %s", user));

    }
}
