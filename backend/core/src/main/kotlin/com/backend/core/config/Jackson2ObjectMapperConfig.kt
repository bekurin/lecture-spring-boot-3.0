package com.backend.core.config

import com.backend.core.support.MarkerAnnotationIntroSpector
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Jackson2ObjectMapperConfig {
    @Bean
    fun jackson2ObjectBuilder(): Jackson2ObjectMapperBuilderCustomizer {
        return Jackson2ObjectMapperBuilderCustomizer { builder ->
            builder.annotationIntrospector(MarkerAnnotationIntroSpector())
        }
    }
}
