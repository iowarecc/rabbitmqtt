package com.kevin.rabbit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "abc.error")
public class TopicReceiveError {

    Logger logger = LoggerFactory.getLogger(TopicReceiveError.class);

    @RabbitHandler
    public void process(String s) {
        logger.error("receive error: "+ s);
    }
}
