package com.example.spring_rabbitmq;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;

@SpringBootApplication
public class SpringRabbitmqApplication {

	private static final String QUEUE_NAME = "testQueue";

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqApplication.class, args);
	}

	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	CommandLineRunner sendPing(RabbitTemplate rabbitTemplate) {
		return args -> {
			System.out.println("Service-1: Sending 'ping'...");
			rabbitTemplate.convertAndSend(QUEUE_NAME, "ping");
		};
	}

	@RabbitListener(queues = QUEUE_NAME)
	public void receiveMessage(String message) {
		System.out.println("Service-2: Received message - " + message);
	}
}
