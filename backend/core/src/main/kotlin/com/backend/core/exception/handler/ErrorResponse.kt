package com.backend.core.exception.handler

import java.time.LocalDateTime

data class ErrorResponse(
        val className: String?,
        val message: String?,
        val timestamp: LocalDateTime
)