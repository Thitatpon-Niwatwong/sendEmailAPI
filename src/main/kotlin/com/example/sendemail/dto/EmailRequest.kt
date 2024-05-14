package com.example.emailservice.dto

data class EmailRequest(
    val mailTo: String,
    val subject: String
)
