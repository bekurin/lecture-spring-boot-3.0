package com.backend.core.util

import constant.ProcessType

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
annotation class Marker(
    val type: ProcessType
)
