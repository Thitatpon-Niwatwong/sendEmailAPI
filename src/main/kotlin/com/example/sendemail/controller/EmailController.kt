package com.example.sendemail.controller

import com.example.emailservice.dto.EmailRequest
import com.example.sendemail.service.EmailService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/email")
class EmailController(private val emailService: EmailService) {

    @PostMapping("/send")
    fun sendEmail(@RequestBody emailRequest: EmailRequest): ResponseEntity<String> {
        return emailService.sendEmail(emailRequest)
    }
}
