package com.example.sendemail.service

import com.example.emailservice.dto.EmailRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity

@Service
class EmailService(private val restTemplate: RestTemplate) {

    @Value("\${email.api.url}")
    private lateinit var emailApiUrl: String

    fun sendEmail(emailRequest: EmailRequest): ResponseEntity<String> {
        val templateId = "24051411-3212-8ada-b713-e1287e80d508"
        val mailFrom = "thitatpon_n@protossgroup.com"

        val body = mapOf(
            "template_uuid" to templateId,
            "mail_from" to mailFrom,
            "mail_to" to mapOf("email" to emailRequest.mailTo.email),
            "subject" to emailRequest.subject
        )

        val headers = HttpHeaders().apply {
            set("Content-Type", "application/json")
        }

        val requestEntity = HttpEntity(body, headers)

        return restTemplate.exchange(emailApiUrl, HttpMethod.POST, requestEntity, String::class.java)
    }
}
