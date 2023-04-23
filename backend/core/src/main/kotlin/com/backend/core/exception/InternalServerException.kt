package com.backend.core.exception

import com.example.core.exception.handler.HttpException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class InternalServerException(
    message: String?
) : HttpException(message)