package com.amdocs.media.kafka.listner;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.amdocs.media.kafka.model.User;

@Service
public class KafkaConsumer {

    
    @KafkaListener(topics = "Kafka_User", groupId ="group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "Kafka_User_json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}
