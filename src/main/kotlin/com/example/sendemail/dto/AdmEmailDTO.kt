package com.example.sendemail.dto

import org.springframework.web.multipart.MultipartFile

data class AdmEmailDTO(
    var senderName: String? = null,
    var subject: String? = null,
    var sendFrom: String? = null,
    var sendTo: String? = null,
    var htmlContent: String? = null,
    var fileAttachment: MultipartFile? = null,
    var contentType: String? = null,
    var emailCC: String? = null
)
