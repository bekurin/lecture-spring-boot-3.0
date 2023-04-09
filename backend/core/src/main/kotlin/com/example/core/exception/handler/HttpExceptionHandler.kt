package com.example.core.exception.handler

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class HttpExceptionHandler {
    @ExceptionHandler(HttpException::class)
    fun handlerHttpException(exception: HttpException): ResponseEntity<ErrorResponse> {
        val responseStatus = exception::class.annotations
                .find { annotation -> annotation is ResponseStatus } as? ResponseStatus
                ?: throw TypeCastException("ResponseStatus 를 정의해주세요")
        return ResponseEntity.status(responseStatus.value)
                .body(ErrorResponse(exception::class.simpleName, exception.message, LocalDateTime.now()))
    }
}
