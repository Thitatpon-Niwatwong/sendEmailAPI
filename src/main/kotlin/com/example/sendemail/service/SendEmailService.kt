//package com.example.sendemail.service
//
//import jakarta.mail.MessagingException
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.core.io.FileSystemResource
//import org.springframework.mail.javamail.JavaMailSender
//import org.springframework.mail.javamail.MimeMessageHelper
//import org.springframework.stereotype.Service
//import java.io.File
//
//@Service
//class SendEmailService {
//
//    @Autowired
//    private lateinit var mailSender: JavaMailSender
//
//    @Throws(MessagingException::class)
//    fun sendSimpleEmail(toEmail: String, subject: String, body: String, attachment: String?) {
//        val message = mailSender.createMimeMessage()
//        val helper = MimeMessageHelper(message, true)
//
//        helper.setFrom("64011150@kmitl.ac.th")
//        helper.setTo(toEmail)
//        helper.setSubject(subject)
//        helper.setText(body)
//
//        // Attach the file if attachment is provided
//        attachment.let {
//            val file = FileSystemResource(File(it))
//            helper.addAttachment(file.filename, file)
//        }
//
//        mailSender.send(message)
//        println("Email sent successfully.")
//    }
//}
