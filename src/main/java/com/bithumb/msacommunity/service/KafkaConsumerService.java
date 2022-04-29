package com.bithumb.msacommunity.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class KafkaConsumerService {
    private final Logger logger = (Logger) LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "jsh-board", groupId = "jsh-group")
    public void consume(String message) {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
