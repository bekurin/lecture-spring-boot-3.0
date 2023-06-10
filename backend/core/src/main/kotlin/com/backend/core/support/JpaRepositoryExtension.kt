package com.backend.core.support

import com.backend.core.exception.ResourceNotFoundException
import org.springframework.data.jpa.repository.JpaRepository

inline fun <reified T, R : Any> JpaRepository<T, R>.findByIdOrThrow(id: R, message: String?): T {
    return findById(id)
        .orElseThrow { throw ResourceNotFoundException(message) }
}
