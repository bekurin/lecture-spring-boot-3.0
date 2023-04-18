package com.example.core.domain.history

import com.example.core.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class History(
    memberId: Long,
    vehicleId: Long,
    startSpotId: Long,
    endSpotId: Long,
) : BaseEntity() {
    @Column(nullable = false)
    var memberId: Long = memberId
        protected set

    @Column(nullable = false)
    var vehicleId: Long = vehicleId
        protected set

    @Column(nullable = false)
    var startSpotId: Long = startSpotId
        protected set

    @Column(nullable = false)
    var endSpotId: Long = endSpotId
}