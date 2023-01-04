package com.kafkaservice.controller;

import com.kafkaservice.kafka.JsonKafkaProducer;
import com.kafkaservice.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    private com.kafkaservice.kafka.KafkaProducer KafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        KafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent topic");
    }

    @PostMapping("/publish-json")
    public ResponseEntity<String> publishJson(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent topic");
    }
}
