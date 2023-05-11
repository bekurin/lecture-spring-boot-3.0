package com.backend.core.controller.request

import com.backend.core.domain.spot.Position
import com.backend.core.domain.spot.Spot
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class SpotRequest(
    @field:NotBlank
    val name: String,
    @field:Valid
    val position: PositionRequest
) {
    fun toEntity(): Spot {
        return Spot(name, position = Position(position.latitude, position.longitude))
    }
}

data class PositionRequest(
    @field:Min(0)
    var latitude: Double,
    @field:Min(0)
    var longitude: Double,
)
