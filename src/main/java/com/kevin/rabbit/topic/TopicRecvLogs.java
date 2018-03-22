package com.kevin.rabbit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "msg-inbox-logs")
public class TopicRecvLogs {

    Logger logger = LoggerFactory.getLogger(TopicRecvLogs.class);

    @RabbitHandler()
    public void process(String s) {
        logger.info("info: "+ s);
    }
}
