package com.backend.core.domain.spot

import com.backend.core.annotation.Masked
import com.backend.core.converter.MaskedConverter
import com.backend.core.domain.BaseEntity
import com.backend.core.domain.route.Route
import jakarta.persistence.*

@Entity
class Spot(
    name: String,
    route: Route = Route(),
    position: Position
) : BaseEntity() {
    @Column(nullable = false)
    @Masked("hello! ")
    @Convert(converter = MaskedConverter::class)
    var name: String = name
        protected set

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
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
