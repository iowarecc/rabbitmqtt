package com.kevin.rabbit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "msg-inbox-errors")
public class TopicRecvError {

    Logger logger = LoggerFactory.getLogger(TopicRecvError.class);

    @RabbitHandler
    public void process(String s) {
        logger.error("error: "+ s);
    }
}
