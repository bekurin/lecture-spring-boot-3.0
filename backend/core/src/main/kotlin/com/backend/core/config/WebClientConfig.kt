package com.backend.core.config

import com.backend.core.exception.InternalServerException
import com.backend.core.service.HelloService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatusCode
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class WebClientConfig {

    @Bean
    fun helloService(): HelloService {
        val client = WebClient.builder()
            .defaultStatusHandler(HttpStatusCode::isError) { response ->
                response.bodyToMono(InternalServerException::class.java)
            }
            .baseUrl("<baseUrl>")
            .build()
        val serviceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build()
        return serviceProxyFactory.createClient(HelloService::class.java)
    }
}