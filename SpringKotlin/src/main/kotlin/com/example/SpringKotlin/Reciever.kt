package com.example.SpringKotlin

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
open class Receiver() {

    @RabbitListener(queues = ["service2Queue"])
  open fun receivePingFromService1(message: String) {


        if (message == "ping") {
            println("[Service-2] Received from service2Queue: $message")
        }
    }
}