package com.backend.core.exception.handler

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(HttpException::class)
    fun handlerHttpException(exception: HttpException): ResponseEntity<ErrorResponse> {
        val responseStatus = exception::class.annotations
            .find { annotation -> annotation is ResponseStatus } as? ResponseStatus
            ?: throw TypeCastException("ResponseStatus 를 정의해주세요")
        return ResponseEntity.status(responseStatus.value)
            .body(ErrorResponse(exception::class.simpleName, exception.message, LocalDateTime.now()))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidationException(exception: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val fieldErrors = exception.bindingResult.fieldErrors
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(exception::class.simpleName, fieldErrors.joinToString(), LocalDateTime.now()))
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handlerConstraintViolationException(exception: ConstraintViolationException): ResponseEntity<ErrorResponse> {
        val message = exception
            .constraintViolations
            .joinToString { constraintViolation -> constraintViolation.message }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(exception::class.simpleName, message, LocalDateTime.now()))
    }
}
