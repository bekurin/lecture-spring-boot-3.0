package com.backend.core.domain.vehicle

import com.backend.core.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Vehicle(
    name: String,
    capacity: Int,
) : BaseEntity() {
    @Column(nullable = false)
    var name: String = name
        protected set

    @Column(nullable = false)
    var capacity: Int = capacity
        protected set

}
