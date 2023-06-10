package com.backend.core.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany


@Entity
class Route(
    name: String,
    delay: Int = 0,
    stations: MutableList<Station> = mutableListOf(),
) : BaseEntity() {

    var name: String = name
        protected set

    var delay: Int = delay
        protected set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route", cascade = [CascadeType.ALL])
    var stations: MutableList<Station> = stations
        protected set
}
