package com.tp31.microservicesmessagingproducer.messaging.service;

import com.tp31.microservicesmessagingproducer.messaging.domain.Account;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishAccount(Account account) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, account);
    }
}
