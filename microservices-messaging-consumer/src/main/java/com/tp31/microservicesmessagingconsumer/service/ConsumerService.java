package com.tp31.microservicesmessagingconsumer.service;

import com.tp31.microservicesmessagingconsumer.domain.Account;
import com.tp31.microservicesmessagingconsumer.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final AccountRepository accountRepository;
    private static final Logger log = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    public ConsumerService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void processAccountMessage(Account account) {
        log.info("Received account message from queue: {}", account);

        Account savedAccount = accountRepository.save(account);

        log.info("Account successfully persisted to database with ID: {}", savedAccount.getId());
    }
}