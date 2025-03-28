package com.example.SpringKotlin

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
open class Receiver(private val sender: Sender) {

    @RabbitListener(queues = ["service2Queue"])
   open fun receivePingFromService1(message: String) {
        println("[Service-2] Received from Service-1: $message")

        if (message == "ping") {
            sender.sendPongToService2() // Respond with "pong"

            Thread.sleep(10_000) // Wait 10 seconds

            sender.sendPingToService1() // Restart loop
        }
    }
}
