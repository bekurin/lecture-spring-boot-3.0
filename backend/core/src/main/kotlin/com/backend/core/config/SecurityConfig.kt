package com.backend.core.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .formLogin().disable()
            .anonymous().disable()
            .httpBasic().disable()
            .cors().disable()
            .csrf().disable()
            .authorizeHttpRequests { request ->
                request.anyRequest().permitAll()
            }
            .build()
    }
}