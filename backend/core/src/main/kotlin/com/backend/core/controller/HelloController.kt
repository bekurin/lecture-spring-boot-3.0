package com.backend.core.controller

import com.backend.core.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class HelloController(
    private val helloService: HelloService
) {

    @GetMapping("/hello")
    fun doHello(): Mono<String> {
        return helloService.getGoogle()
    }
}
