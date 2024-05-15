package com.example.sendemail.dto

data class EmailRequest(
    val toEmail: String,
    val subject: String,
    val body: String
)
