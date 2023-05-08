package com.backend.core.controller.response

import com.backend.core.domain.taxi.route.Route

data class RouteResponse(
    val id: Long,
    val spotList: List<SpotResponse>
) {
    constructor(entity: Route) : this(
        id = entity.id,
        spotList = entity.spots.map { SpotResponse(it) }
    )
}
