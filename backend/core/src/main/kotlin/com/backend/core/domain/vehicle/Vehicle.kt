package com.backend.core.domain.vehicle

import com.backend.core.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Vehicle(
        name: String,
        seat: Int,
) : BaseEntity() {
    @Column(nullable = false)
    var name: String = name
        protected set

    @Column(nullable = false)
    var seat: Int = seat
        protected set

}
