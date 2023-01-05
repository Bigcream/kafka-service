package com.kafkaservice.kafka.consumer;

import com.example.appchat.service.UserChatService;
import com.kafkaservice.constant.KafkaGroup;
import com.kafkaservice.constant.KafkaTopic;
import com.kafkaservice.payload.MessageKafka;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatPrivateConsumer {
    private final UserChatService userChatService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatPublicConsumer.class);

    @KafkaListener(topics = KafkaTopic.PRIVATE_CHAT_TOPIC, groupId = KafkaGroup.PRIVATE_CHAT_GROUP)
    public void privateChatConsumer1(ConsumerRecord<String, String> record, MessageKafka messageKafka) throws Exception {
        sendMessagePrivate(record, messageKafka);
        LOGGER.info("Message received private 1");
    }

    @KafkaListener(topics = KafkaTopic.PRIVATE_CHAT_TOPIC, groupId = KafkaGroup.PRIVATE_CHAT_GROUP)
    public void privateChatConsumer2(ConsumerRecord<String, String> record, MessageKafka messageKafka) throws Exception {
        sendMessagePrivate(record, messageKafka);
        LOGGER.info("Message received private 2");
    }

    @KafkaListener(topics = KafkaTopic.PRIVATE_CHAT_TOPIC, groupId = KafkaGroup.PRIVATE_CHAT_GROUP)
    public void privateChatConsumer3(ConsumerRecord<String, String> record, MessageKafka messageKafka) throws Exception {
        sendMessagePrivate(record, messageKafka);
        LOGGER.info("Message received private 3");
    }

    public void sendMessagePrivate(ConsumerRecord<String, String> record, MessageKafka messageKafka) throws Exception {
//        UserEntity user = objectMapperUtil.convertObject(UserEntity.class, messageKafka.getData());
//        messageKafka.setSenderName(user.getUsername());
//        messageKafka.setReceiverName(user.getUsername());
//        userChatService.sendPrivateChat(messageKafka);
        System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
    }
}
