package com.example.sendemail

import com.example.sendemail.service.EmailSenderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener

@SpringBootApplication
class SendemailApplication {

	@Autowired
	private lateinit var senderService: EmailSenderService

	@EventListener(ApplicationReadyEvent::class)
	fun triggerMail() {
		senderService.sendSimpleEmail(
			"thitatpon.tn@gmail.com",
			"pls read",
			"hello world",
		)
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<SendemailApplication>(*args)
		}
	}
}
