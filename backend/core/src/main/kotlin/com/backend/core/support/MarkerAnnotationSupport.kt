package com.backend.core.support

import com.backend.core.util.Marker
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.BeanProperty
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.introspect.Annotated
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector
import com.fasterxml.jackson.databind.ser.ContextualSerializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import constant.ProcessType
import ensure.EnsureUtils

class MarkerAnnotationIntroSpector : JacksonAnnotationIntrospector() {
    override fun findSerializer(am: Annotated): Any? {
        val marker = am.getAnnotation(Marker::class.java) ?: return super.findSerializer(am)
        return MarkerSerializer(marker.type)
    }
}

class MarkerSerializer(
    private val type: ProcessType
) : StdSerializer<String>(String::class.java), ContextualSerializer {
    override fun serialize(value: String, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeString(EnsureUtils.ensure(value, type))
    }

    override fun createContextual(prov: SerializerProvider, property: BeanProperty): JsonSerializer<*> {
        val marker = property.getAnnotation(Marker::class.java)
        if (marker != null) {
            return MarkerSerializer(marker.type)
        }
        return prov.findKeySerializer(property.type, property)
    }
}
