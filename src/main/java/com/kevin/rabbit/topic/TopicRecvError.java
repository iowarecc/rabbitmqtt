package com.kevin.rabbit.topic;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TopicRecvError {

    Logger logger = LoggerFactory.getLogger(TopicRecvError.class);

    @RabbitListener(queues = "msg-inbox-errors")
    public void process(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        logger.error("error: "+ new String(message.getBody()));
    }
}
