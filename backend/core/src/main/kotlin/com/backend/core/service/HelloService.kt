package com.backend.core.service

import org.springframework.http.MediaType
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import reactor.core.publisher.Mono

@HttpExchange(
    url = "/",
    contentType = MediaType.APPLICATION_JSON_VALUE,
    accept = [MediaType.APPLICATION_JSON_VALUE]
)
interface HelloService {
    @GetExchange
    fun getGoogle(): Mono<String>
}
