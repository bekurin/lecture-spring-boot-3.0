package com.backend.core.domain.station

import com.backend.core.domain.BaseEntity
import com.backend.core.domain.route.Route
import com.backend.core.domain.spot.Spot
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Station(
    spot: Spot,
    route: Route,
    arrivedAt: LocalDateTime,
    departedAt: LocalDateTime,
    stationType: StationType,
) : BaseEntity() {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spot_id")
    var spot: Spot = spot

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "route_id")
    var route: Route = route
        protected set

    var arrivedAt: LocalDateTime = arrivedAt
        protected set

    var departedAt: LocalDateTime = departedAt
        protected set

    var stationType: StationType = stationType
        protected set
}

enum class StationType(
    private val description: String
) {
    DEPARTURE_GARAGE("출발 차고지"),
    STATION("정차역"),
    DESTINATION("종점"),
    DESTINATION_GARAGE("종점 차고지")
}
