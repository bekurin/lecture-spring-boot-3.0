package com.backend.core.controller

import com.example.core.exception.ClientBadRequestException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun doHello(): Map<String, String> {
        return mapOf("message" to "hello")
    }

    @GetMapping("/exception")
    fun throwException() {
        throw ClientBadRequestException("테스트 메시지를 입력합니다")
    }
}