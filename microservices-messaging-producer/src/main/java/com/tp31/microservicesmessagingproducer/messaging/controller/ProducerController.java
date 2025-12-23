package com.tp31.microservicesmessagingproducer.messaging.controller;

import com.tp31.microservicesmessagingproducer.messaging.domain.Account;
import com.tp31.microservicesmessagingproducer.messaging.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class ProducerController {

    private final ProducerService producerService;
    private static final Logger log = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> publishAccountMessage(@RequestBody Account account) {
        producerService.publishAccount(account);
        log.info("Account published to message queue: {}", account);
        return ResponseEntity.ok("Account successfully published: " + account.getAccountId());
    }
}
