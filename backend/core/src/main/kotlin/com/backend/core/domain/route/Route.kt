package com.backend.core.domain.route

import com.backend.core.domain.BaseEntity
import com.backend.core.domain.spot.Spot
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany


@Entity
class Route(
    spots: MutableList<Spot> = mutableListOf()
) : BaseEntity() {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "spot")
    var spots: MutableList<Spot> = spots
        protected set

}