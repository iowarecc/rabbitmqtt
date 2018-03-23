package com.kevin.rabbit.topic2;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CriticalConfig {

    @Bean
    public Queue queueCritical() {
        return new Queue("critical");
    }

    @Bean
    public Queue queueRateLimiting() {
        return new Queue("rate_limiting");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("alert-exchange");
    }

    @Bean
    Binding bindingExchangeCritical(Queue queueCritical, TopicExchange exchange) {
        return BindingBuilder.bind(queueCritical).to(exchange).with("critical.*");
    }

    @Bean
    Binding bindingExchangeLimiting(Queue queueRateLimiting, TopicExchange exchange) {
        return BindingBuilder.bind(queueRateLimiting).to(exchange).with("*.rate_limiting");
    }

}
