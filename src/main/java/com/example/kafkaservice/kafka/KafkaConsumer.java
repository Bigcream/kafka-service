package com.example.kafkaservice.kafka;

import com.example.kafkaservice.payload.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private KafkaProducer kafkaProducer;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "demoTopic")
    public void consume(String message){
        LOGGER.info(String.format("Message received hello -> %s", message));

    }

    @KafkaListener(topics = "demoTopicJson", groupId = "myGroup")
    public void consume1(ConsumerRecord<String, String> record, User user){
        LOGGER.info(String.format("Message received 1 -> %s", user));
        System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());

    }

    @KafkaListener(topics = "demoTopicJson", groupId = "myGroup")
    public void consume2(ConsumerRecord<String, String> record, User user){
        LOGGER.info(String.format("Message received 2 -> %s", user));
        System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());

    }

    @KafkaListener(topics = "demoTopicJson", groupId = "myGroup")
    public void consume(ConsumerRecord<String, String> record, User user){
        LOGGER.info(String.format("Message received 3 -> %s", user));
        System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());

        kafkaProducer.sendMessage("hello kafka");

    }
}
