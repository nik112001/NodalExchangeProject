package com.example.spring_rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class SpringRabbitmqApplication implements CommandLineRunner {
	// Autowire the Sender class to send messages
	@Autowired
	private Sender sender;

	// Main method to start the Spring application
	public static void main(String[] args) {
		System.out.println("Starting the Spring application...");
		SpringApplication.run(SpringRabbitmqApplication.class, args);
	}

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

	@Override
	public void run(String... args) throws Exception {
		System.out.println("The first iteration of the Ping-Pong loop");
		sender.startPingLoop(); // Start the ping-pong loop when the app starts
	}
}
