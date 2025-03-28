package com.example.SpringKotlin.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class RabbitMQConfig {

    // Define the queues
    @Bean
    open fun service1Queue(): Queue = Queue("service1Queue", true)

    @Bean
    open fun service2Queue(): Queue = Queue("service2Queue", true)

    // Define the exchange
    @Bean
    open fun exchange(): TopicExchange = TopicExchange("serviceExchange")

    // Bind service1Queue to the exchange
    @Bean
    open fun bindingService1Queue(): Binding {
        return BindingBuilder.bind(service1Queue()).to(exchange()).with("service1.routing.key")
    }

    // Bind service2Queue to the exchange
    @Bean
    open fun bindingService2Queue(): Binding {
        return BindingBuilder.bind(service2Queue()).to(exchange()).with("service2.routing.key")
    }
}
