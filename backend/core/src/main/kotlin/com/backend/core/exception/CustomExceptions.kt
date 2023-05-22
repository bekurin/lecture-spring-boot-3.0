package com.backend.core.exception

import com.backend.core.exception.handler.HttpException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class ClientBadRequestException(message: String? = null) : HttpException(message)

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class InternalServerException(
    message: String?
) : HttpException(message)

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(
    message: String?
) : HttpException(message)
