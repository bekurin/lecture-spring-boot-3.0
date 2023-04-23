package com.backend.core.domain

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity: TimestampBaseEntity() {
    @Id
    @Column(nullable = false, updatable = false)
    var id: Long = 0L
}