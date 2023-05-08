package com.backend.core.controller.response

import com.backend.core.domain.taxi.spot.Position
import com.backend.core.domain.taxi.spot.Spot
import com.backend.core.util.Marker
import constant.ProcessType

data class SpotResponse(
    val id: Long,
    @Marker(type = ProcessType.NAME)
    val name: String,
    val position: Position
) {
    constructor(entity: Spot) : this(
        id = entity.id,
        name = entity.name,
        position = entity.position
    )
}
