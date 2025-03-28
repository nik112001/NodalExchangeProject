package com.example.spring_rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Declare the queues explicitly so they will be created
    @Bean
    public Queue service2Queue() {
        return new Queue("service2Queue", true); // Durable queue (persists messages)
    }

    @Bean
    public Queue service1Queue() {
        return new Queue("service1Queue", true); // Durable queue (persists messages)
    }

    // Declare a direct exchange
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct-exchange");
    }

    // Bind the queues to the exchange with routing keys
    @Bean
    public Binding bindService1QueueToExchange() {
        return BindingBuilder.bind(service1Queue()).to(directExchange()).with("service1Queue");
    }

    @Bean
    public Binding bindService2QueueToExchange() {
        return BindingBuilder.bind(service2Queue()).to(directExchange()).with("service2Queue");
    }
}
