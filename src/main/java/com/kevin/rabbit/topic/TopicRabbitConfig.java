package com.kevin.rabbit.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    final static String info = "abc.info";

    final static String error = "abc.error";

    @Bean
    public Queue queueInfo() {
        return new Queue(TopicRabbitConfig.info);
    }

    @Bean
    public Queue queueError() {
        return new Queue(TopicRabbitConfig.error);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("my-topic-exchange");
    }

    @Bean
    Binding bindingExchangeInfo(Queue queueInfo, TopicExchange exchange) {
        return BindingBuilder.bind(queueInfo).to(exchange).with("abc.#");
    }

    @Bean
    Binding bindingExchangeError(Queue queueError, TopicExchange exchange) {
        return BindingBuilder.bind(queueError).to(exchange).with("abc.error");
    }
}
