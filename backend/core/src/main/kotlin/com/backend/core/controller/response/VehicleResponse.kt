package com.backend.core.controller.response

import com.backend.core.domain.vehicle.Vehicle
import java.time.LocalDateTime

data class VehicleResponse(
    val id: Long,
    val name: String,
    val capacity: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(entity: Vehicle) : this(
        id = entity.id,
        name = entity.name,
        capacity = entity.capacity,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )
}
