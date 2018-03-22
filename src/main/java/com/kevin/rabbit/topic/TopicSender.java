package com.kevin.rabbit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    Logger logger = LoggerFactory.getLogger(TopicSender.class);

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void send1() {
        String content = "topic, send errors";
        logger.info("send1: "+ content);
        this.rabbitTemplate.convertAndSend("my-topic-exchange", "error.msg-inbox", content);
    }

    public void send2() {
        String content = "topic, send warn";
        logger.info("send2: "+ content);
        this.rabbitTemplate.convertAndSend("my-topic-exchange", "warn.msg-inbox", content);
    }

    public void send3() {
        String content = "topic, send info";
        logger.info("send3: "+ content);
        this.rabbitTemplate.convertAndSend("my-topic-exchange", "info.msg-inbox", content);
    }
}
