package com.example.sendemail.controller

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
        // แนบไฟล์ที่ต้องการส่งกลับ
        val attachmentPath = "path/to/your/attachment.txt"
        emailSenderService.sendEmailWithAttachment(
            emailRequest.toEmail,
            "Re: ${emailRequest.subject}",
            "This is an automatic response to your email: ${emailRequest.body}",
            attachmentPath
        )
    }
}

data class EmailRequest(
    val toEmail: String,
    val subject: String,
    val body: String
)
