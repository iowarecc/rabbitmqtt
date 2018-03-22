package com.kevin.rabbit.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue queueErrors() {
        return new Queue("msg-inbox-errors");
    }

    @Bean
    public Queue queueLogs() {
        return new Queue("msg-inbox-logs");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("my-topic-exchange");
    }

    @Bean
    Binding bindingExchangeErrors(Queue queueErrors, TopicExchange exchange) {
        return BindingBuilder.bind(queueErrors).to(exchange).with("error.msg-inbox");
    }

    @Bean
    Binding bindingExchangeError(Queue queueLogs, TopicExchange exchange) {
        return BindingBuilder.bind(queueLogs).to(exchange).with("*.msg-inbox");
    }

}
