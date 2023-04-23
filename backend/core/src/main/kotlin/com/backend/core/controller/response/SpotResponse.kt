package com.backend.core.controller.response

import com.backend.core.domain.spot.Position
import com.backend.core.domain.spot.Spot

data class SpotResponse(
    val id: Long,
    val name: String,
    val position: Position
) {
    constructor(entity: Spot) : this(
        id = entity.id,
        name = entity.name,
        position = entity.position
    )
}