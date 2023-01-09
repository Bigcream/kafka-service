package com.kafkaservice.kafka.consumer;

import com.kafkaservice.constant.AppChatApi;
import com.kafkaservice.constant.KafkaGroup;
import com.kafkaservice.constant.KafkaTopic;
import com.kafkaservice.payload.MessageKafka;
import com.kafkaservice.util.AppChatServiceUtil;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatPublicConsumer {
    private final AppChatServiceUtil appChatServiceUtil;
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatPublicConsumer.class);

    @KafkaListener(topics = KafkaTopic.PUBLIC_CHAT_TOPIC, groupId = KafkaGroup.PUBLIC_CHAT_GROUP)
    public void publicChatConsumer1(ConsumerRecord<String, String> record, MessageKafka messageKafka) throws Exception {
        sendMessagePublic(record, messageKafka);
        LOGGER.info("Message received 1");
    }

    @KafkaListener(topics = KafkaTopic.PUBLIC_CHAT_TOPIC, groupId = KafkaGroup.PUBLIC_CHAT_GROUP)
    public void publicChatConsumer2(ConsumerRecord<String, String> record, MessageKafka messageKafka) throws Exception {
        sendMessagePublic(record, messageKafka);
        LOGGER.info("Message received 2");
    }

    @KafkaListener(topics = KafkaTopic.PUBLIC_CHAT_TOPIC, groupId = KafkaGroup.PUBLIC_CHAT_GROUP)
    public void publicChatConsumer3(ConsumerRecord<String, String> record, MessageKafka messageKafka) throws Exception {
        sendMessagePublic(record, messageKafka);
        LOGGER.info("Message received 3");
    }

    public void sendMessagePublic(ConsumerRecord<String, String> record, MessageKafka messageKafka) throws Exception {
//        UserEntity user = objectMapperUtil.convertObject(UserEntity.class, messageKafka.getData());
//        messageKafka.setSenderName(user.getUsername());
        appChatServiceUtil.sendMessage(messageKafka, AppChatApi.SEND_PUBLIC_CHAT);
        System.out.println("test" + messageKafka.getContent());
    }
}

