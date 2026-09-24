package com.example.QuestionService.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {



    private final KafkaTemplate <String, String> kafkaTemplate;

    private static final String TOPIC = "question-topic";

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message)
    {
        kafkaTemplate.send("question-topic", message);

        System.out.println("Message Sent :" +message);



    }
}





// Purpose: Send a message to kafka 
