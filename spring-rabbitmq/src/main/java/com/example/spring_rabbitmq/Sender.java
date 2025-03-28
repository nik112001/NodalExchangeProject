package com.example.spring_rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Component;

@Component
public class Sender {
    private final RabbitTemplate rabbitTemplate;
    private static final String SERVICE2_QUEUE = "service2Queue";
    private static final String SERVICE1_QUEUE = "service1Queue";

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void startPingLoop() {
        sendPingToService2();
    }

    public void sendPingToService2() {
        String message = "ping";
        rabbitTemplate.convertAndSend(SERVICE2_QUEUE, message);
        System.out.println("[Service-1] Sent to Service-2: " + message);
    }

    public void sendPongToService1() {
        String message = "pong";
        rabbitTemplate.convertAndSend(SERVICE1_QUEUE, message);
        System.out.println("[Service-1] Sent to service1Queue: " + message);
    }
}
