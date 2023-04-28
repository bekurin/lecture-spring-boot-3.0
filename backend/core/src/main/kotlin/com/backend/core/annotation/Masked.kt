package com.backend.core.annotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class Masked(
    val processType: String = ""
)
