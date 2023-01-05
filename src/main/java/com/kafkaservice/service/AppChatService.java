package com.kafkaservice.service;

import com.kafkaservice.payload.MessageKafka;
import org.springframework.stereotype.Service;

@Service
public class AppChatService {
    public MessageKafka sendToAppChat(){
        return new MessageKafka();
    }
}
