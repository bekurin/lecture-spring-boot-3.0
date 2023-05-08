package com.backend.core.controller.request

import com.backend.core.domain.taxi.spot.Position

data class SpotRequest(
    val name: String,
    val position: Position
)
