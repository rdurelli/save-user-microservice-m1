package com.example.saveuser.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String queueName, Object messageToSend) {
        this.rabbitTemplate.convertAndSend(queueName, messageToSend);
    }
}
