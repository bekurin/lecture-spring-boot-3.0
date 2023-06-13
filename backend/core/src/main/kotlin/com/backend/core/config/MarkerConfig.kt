package com.backend.core.config

import com.backend.core.util.Marker
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.AnnotationIntrospector
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.introspect.Annotated
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import constant.ProcessType
import ensure.EnsureUtils
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MarkerConfig {
    @Bean
    fun jackson2ObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer {
        val originAnnotationIntrospector = jacksonObjectMapper().serializationConfig.annotationIntrospector
        return Jackson2ObjectMapperBuilderCustomizer { builder ->
            builder.annotationIntrospector(
                AnnotationIntrospector.pair(
                    MarkerAnnotationIntroSpector(),
                    originAnnotationIntrospector
                )
            )
        }
    }
}

class MarkerAnnotationIntroSpector : NopAnnotationIntrospector() {
    override fun findSerializer(annotated: Annotated): Any? {
        val marker = annotated.getAnnotation(Marker::class.java) ?: return null
        return MarkerSerializer(marker.type)
    }
}

class MarkerSerializer(private val type: ProcessType) : JsonSerializer<String>() {
    override fun serialize(value: String, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString(EnsureUtils.ensure(value, type))
    }
}
