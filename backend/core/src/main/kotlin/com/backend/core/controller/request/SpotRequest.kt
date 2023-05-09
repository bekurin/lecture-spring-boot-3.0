package com.backend.core.controller.request

import com.backend.core.domain.spot.Position
import jakarta.validation.constraints.NotBlank

data class SpotRequest(
    @field:NotBlank(message = "name must not be blank")
    val name: String,
    val position: Position
)
