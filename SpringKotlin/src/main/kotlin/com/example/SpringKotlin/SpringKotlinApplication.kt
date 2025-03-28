package com.example.SpringKotlin

import org.springframework.amqp.core.Queue
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.boot.autoconfigure.EnableAutoConfiguration


@SpringBootApplication
@EnableAutoConfiguration
open class SpringKotlinApplication {

	@Bean
	open fun service1Queue(): Queue = Queue("service1Queue", true)

	@Bean
	open fun service2Queue(): Queue = Queue("service2Queue", true)
}

fun main(args: Array<String>) {
	runApplication<SpringKotlinApplication>(*args)
}
