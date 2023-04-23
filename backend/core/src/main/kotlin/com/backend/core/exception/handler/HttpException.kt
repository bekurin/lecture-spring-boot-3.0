package com.backend.core.exception.handler

open class HttpException(
        message: String? = null
) : RuntimeException(message)