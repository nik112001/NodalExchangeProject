package com.example.SpringKotlin

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class Receiver(private val sender: Sender) {

    @RabbitListener(queues = ["service2Queue"])
    fun receivePingFromService1(message: String) {
        println("[Service-2] Received from service2Queue: $message")

        if (message == "ping") {
            sender.sendPongToService2() // Respond with "pong"

            Thread.sleep(10_000) // Wait 10 seconds

            sender.sendPingToService1() // Restart loop
        }
    }
}
