package com.example.demokafka.controller;

import com.example.demokafka.kafka.JsonKafkaProducer;
import com.example.demokafka.kafka.KafkaProducer;
import com.example.demokafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    @Autowired
    private RedisTemplate<String, String> template;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    private KafkaProducer KafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        User user = new User();
        user.setId(1);
        user.setFirstName("abc");
        user.setLastName("123");
        template.opsForValue().set("loda", String.valueOf(user));

        // In ra màn hình Giá trị của key "loda" trong Redis
        System.out.println("Value of key loda: "+template.opsForValue().get("loda"));
        return ResponseEntity.ok("Message sent topic" + String.valueOf(user));
    }

    @PostMapping("/publish-json")
    public ResponseEntity<String> publishJson(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent topic");
    }
}
