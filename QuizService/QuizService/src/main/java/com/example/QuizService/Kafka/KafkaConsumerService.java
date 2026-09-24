package com.example.QuizService.Kafka;


import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "question-topic",
            groupId = "quiz-group"
    )

    public  void consumer(String message){
        System.out.println("Message Recives"+message);
    }


}
