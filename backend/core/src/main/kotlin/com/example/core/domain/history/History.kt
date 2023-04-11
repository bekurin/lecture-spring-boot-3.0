package com.example.core.domain.history

import com.example.core.domain.BaseEntity
import jakarta.persistence.Entity

@Entity
class History(
        var memberId: Long,
        var vehicleId: Long,
        var startSpotId: Long,
        var endSpotId: Long,
        var utilizationMinute: Long
) : BaseEntity() {
}