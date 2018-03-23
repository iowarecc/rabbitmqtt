package com.kevin.rabbit.topic2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TSender {

    Logger logger = LoggerFactory.getLogger(TSender.class);

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("alert-exchange", "critical.hello", "这是关键错误");
        rabbitTemplate.convertAndSend("alert-exchange", "abc.rate_limiting", "这是频次错误");
        rabbitTemplate.convertAndSend("alert-exchange", "critical.rate_limiting", "这是关键错误+频次错误");
    }

}
