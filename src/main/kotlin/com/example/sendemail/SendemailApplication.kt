package com.example.sendemail

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener

@SpringBootApplication
class SendemailApplication

fun main(args: Array<String>) {
	runApplication<SendemailApplication>(*args)
}
