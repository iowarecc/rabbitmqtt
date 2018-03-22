package com.kevin.rabbit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "abc.info")
public class TopicReceiveInfo {

    Logger logger = LoggerFactory.getLogger(TopicReceiveInfo.class);

    @RabbitHandler
    public void process(String s) {
        logger.info("receive info: "+ s);
    }
}