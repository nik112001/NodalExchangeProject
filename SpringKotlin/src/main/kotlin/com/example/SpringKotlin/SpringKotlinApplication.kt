package com.example.SpringKotlin

import org.springframework.amqp.core.Queue
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class SpringKotlinApplication {
	@Bean
	open fun service2Queue(): Queue = Queue("service2Queue", false)


}

fun main(args: Array<String>) {
	runApplication<SpringKotlinApplication>(*args)
}