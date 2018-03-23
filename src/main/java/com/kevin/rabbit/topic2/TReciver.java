package com.kevin.rabbit.topic2;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TReciver {
    Logger logger = LoggerFactory.getLogger(TReciver.class);

    @RabbitListener(queues = "critical")
    public void process1(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        logger.warn("critical: " + new String(message.getBody()));
    }

    @RabbitListener(queues = "rate_limiting")
    public void process2(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        logger.error("rate_limiting: " + new String(message.getBody()));
    }

}