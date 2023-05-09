package com.backend.core.controller.request

import com.backend.core.domain.spot.Position

data class SpotRequest(
    val name: String,
    val position: Position
)
