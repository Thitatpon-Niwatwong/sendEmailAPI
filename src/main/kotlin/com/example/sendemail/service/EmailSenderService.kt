package com.example.sendemail.service

import jakarta.mail.MessagingException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class EmailSenderService {

    @Autowired
    private lateinit var mailSender: JavaMailSender

    @Throws(MessagingException::class)
    fun sendSimpleEmail(toEmail: String, subject: String, body: String) {
        val message = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true)

        helper.setFrom("64011150@kmitl.ac.th")
        helper.setTo(toEmail)
        helper.setSubject(subject)
        helper.setText(body)

        mailSender.send(message)
        println("Email sent successfully.")
    }
}
