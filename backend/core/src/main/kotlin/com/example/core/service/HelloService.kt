package com.example.core.service

import org.springframework.web.service.annotation.GetExchange
import reactor.core.publisher.Mono

interface HelloService {

    @GetExchange("/v1/hello")
    fun hi(): Mono<Void>
}