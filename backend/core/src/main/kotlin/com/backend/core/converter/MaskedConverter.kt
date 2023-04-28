package com.backend.core.converter

import com.backend.core.annotation.Masked
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import kotlin.reflect.full.findAnnotation

@Converter
class MaskedConverter : AttributeConverter<String, kotlin.String> {
    override fun convertToDatabaseColumn(attribute: String?): String {
        return attribute ?: throw NullPointerException()
    }

    override fun convertToEntityAttribute(dbData: String?): String {
        val masked = dbData!!::class.findAnnotation<Masked>() ?: throw NullPointerException()
        return "$dbData${masked.processType}"
    }
}
