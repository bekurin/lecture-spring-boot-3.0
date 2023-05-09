package com.backend.core.config

import org.springframework.context.annotation.Configuration

@Configuration
class Jackson2ObjectMapperConfig {
//    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.backend.core.controller.request.SpotRequest` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
//    에러 발생
//    @Bean
//    fun jackson2ObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer {
//        return Jackson2ObjectMapperBuilderCustomizer { builder ->
//            builder.annotationIntrospector(MarkerAnnotationIntroSpector())
//        }
//    }
}
