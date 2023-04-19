package com.example.core.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .formLogin().disable()
            .cors().disable()
            .csrf().disable()
            .authorizeHttpRequests { request ->
                request.requestMatchers(HttpMethod.PUT, "/**").hasAnyRole("admin")
                request.requestMatchers(HttpMethod.POST, "/**").hasAnyRole("admin")
                request.requestMatchers(HttpMethod.PATCH, "/**").hasAnyRole("admin")
                request.requestMatchers(HttpMethod.DELETE, "/**").hasAnyRole("admin")
            }
            .build()
    }
}