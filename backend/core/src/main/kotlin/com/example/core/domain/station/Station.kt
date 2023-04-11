package com.example.core.domain.station

import com.example.core.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.Entity

@Embeddable
data class Position(
        var latitude: Double,
        var longitude: Double,
)

@Entity
class Station(
        name: String,
        position: Position,
) : BaseEntity() {

    @Column(nullable = false)
    var name = name
        protected set

    @Embedded
    @Column(nullable = false)
    var position = position
        protected set
}