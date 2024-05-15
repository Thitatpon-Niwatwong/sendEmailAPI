package com.example.emailservice.dto

data class EmailRequest(
    val mailTo: MailTo,
    val subject: String
)

data class MailTo(
    val email: String
)
