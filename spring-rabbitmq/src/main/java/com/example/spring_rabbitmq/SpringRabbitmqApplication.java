package com.example.spring_rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	// CommandLineRunner to start the ping-pong loop
	@Override
	public void run(String... args) throws Exception {
		System.out.println("The first iteration of the Ping-Pong loop");
		sender.startPingLoop(); // Start the ping-pong loop when the app starts
	}
}
