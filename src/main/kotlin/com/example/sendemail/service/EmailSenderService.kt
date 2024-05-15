package com.example.sendemail.service

import jakarta.mail.MessagingException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import java.io.File

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

    @Throws(MessagingException::class)
    fun sendEmailWithAttachment(toEmail: String, subject: String, body: String, attachmentPath: String) {
        val message = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true)

        helper.setFrom("64011150@kmitl.ac.th")
        helper.setTo(toEmail)
        helper.setSubject(subject)
        helper.setText(body)

        // แนบไฟล์
        val file = File(attachmentPath)
        if (file.exists()) {
            helper.addAttachment(file.name, file)
        }

        mailSender.send(message)
        println("Email with attachment sent successfully.")
    }
}
