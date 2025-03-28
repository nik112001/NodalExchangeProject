package com.example.SpringKotlin

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class Sender @Autowired constructor(private val rabbitTemplate: RabbitTemplate) {

    // Send "pong" to service2Queue
    fun sendPongToService2() {
        rabbitTemplate.convertAndSend("service2Queue", "pong")
        println("[Service-2] Sent pong ")
    }

    // Send "ping" to service1Queue
    fun sendPingToService1() {
        rabbitTemplate.convertAndSend("service1Queue", "ping")
        println("[Service-2] Sent ping to Service-1")
    }
}
