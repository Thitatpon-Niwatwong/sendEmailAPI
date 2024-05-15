package com.example.sendemail.controller

import com.example.sendemail.dto.EmailRequest
import com.example.sendemail.service.EmailSenderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/email")
class EmailController {

    @Autowired
    private lateinit var emailSenderService: EmailSenderService

    @PostMapping("/receive")
    fun receiveEmail(@RequestBody emailRequest: EmailRequest) {
        val attachmentPath = "C:\\Users\\thita\\Desktop\\New folder\\Text.txt"
        emailSenderService.sendEmailWithAttachment(
            emailRequest.toEmail,
            "Re: ${emailRequest.subject}",
            "This is an automatic response to your email: ${emailRequest.body}",
            attachmentPath
        )
    }
}