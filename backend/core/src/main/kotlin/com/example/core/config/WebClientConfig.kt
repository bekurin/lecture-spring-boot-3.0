package com.example.core.config

import com.example.core.service.HelloService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class WebClientConfig {

    @Bean
    fun helloService(): HelloService {
        val client = WebClient.create("<domain>")
        val serviceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build()
        return serviceProxyFactory.createClient(HelloService::class.java)
    }
}