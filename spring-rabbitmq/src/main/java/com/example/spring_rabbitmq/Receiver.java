package com.example.spring_rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class Receiver {
    private final Sender sender; // Inject sender to send responses

    public Receiver(Sender sender) {
        this.sender = sender;
    }

    @RabbitListener(queues = "service1Queue")
    public void receivePingFromService2(String message) {


        if ("ping".equals(message)) {
            System.out.println("[Service-1] Received from Service-2: " + message);
            sender.sendPongToService1(); // Respond with "pong"
            System.out.println("Ping-Pong loop  about to restart in 10 seconds ");

            try {
                Thread.sleep(10000); // Wait 10 seconds before restarting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            sender.sendPingToService2(); // Restart loop
        }


    }
}
