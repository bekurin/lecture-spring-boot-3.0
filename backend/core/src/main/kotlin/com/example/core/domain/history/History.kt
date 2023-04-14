package com.example.core.domain.history

import com.example.core.domain.BaseEntity
import jakarta.persistence.Entity

@Entity
class History(
        memberId: Long,
        vehicleId: Long,
        startSpotId: Long,
        endSpotId: Long,
        utilizationMinute: Long
) : BaseEntity() {

}