package com.backend.core.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.Entity

@Entity
class Spot(
    name: String,
    position: Position
) : BaseEntity() {
    @Column(nullable = false)
    var name: String = name
        protected set

    @Embedded
    @Column(nullable = false)
    var position: Position = position
        protected set
}

@Embeddable
data class Position(
    var latitude: Double,
    var longitude: Double,
)
