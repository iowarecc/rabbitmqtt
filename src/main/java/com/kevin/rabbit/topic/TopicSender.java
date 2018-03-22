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

    public void send0() {
        String content = "topic, send x";
        logger.info("send: "+ content);
        this.rabbitTemplate.convertAndSend("my-topic-exchange", "abc.x", content);
    }

    public void send1() {
        String content = "topic, send info";
        logger.info("send: "+ content);
        this.rabbitTemplate.convertAndSend("my-topic-exchange", "abc.info", content);
    }

    public void send2() {
        String content = "topic, send infos infos";
        logger.info("send: "+ content);
        this.rabbitTemplate.convertAndSend("my-topic-exchange", "abc.error", content);
    }
}
