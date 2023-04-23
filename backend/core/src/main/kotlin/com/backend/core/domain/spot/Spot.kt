package com.backend.core.domain.spot

import com.example.core.domain.BaseEntity
import com.example.core.domain.route.Route
import jakarta.persistence.*

@Entity
class Spot(
        name: String,
        route: Route,
        position: Position
) : BaseEntity() {
    @Column(nullable = false)
    var name: String = name
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    var route: Route = route
        protected set

    @Embedded
    @Column(nullable = false)
    var position: Position = position
        protected set
}

@Embeddable
data class Position(
        var latitude: Double,
        var longitude: Double,
)