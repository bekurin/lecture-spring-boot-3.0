package com.example.core.exception

import com.example.core.exception.handler.CustomException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class ClientBadRequestException(message: String? = null) : CustomException(message)