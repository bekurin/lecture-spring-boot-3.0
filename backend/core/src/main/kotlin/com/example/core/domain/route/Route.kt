package com.example.core.domain.route

import com.example.core.domain.BaseEntity
import com.example.core.domain.spot.Spot
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany


@Entity
class Route(
        spots: List<Spot>
) : BaseEntity() {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "spot")
    var spots: List<Spot> = spots
        protected set

}