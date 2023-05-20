package com.backend.core.domain.station

import com.backend.core.domain.BaseEntity
import com.backend.core.domain.route.Route
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Station(
    spotId: Long,
    arrivedAt: LocalDateTime,
    route: Route
) : BaseEntity() {
    var spotId: Long = spotId
        protected set

    var arrivedAt: LocalDateTime = arrivedAt

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "route_id")
    var route: Route = route
        protected set
}
