package com.backend.core.domain.ticket

import com.backend.core.domain.BaseEntity
import jakarta.persistence.Entity

@Entity
class Ticket(
    routeId: Long,
    departureStationId: Long,
    arrivalStationId: Long,
) : BaseEntity() {

    var routeId: Long = routeId
        protected set

    var departureStationId: Long = departureStationId
        protected set

    var arrivalStationId: Long = arrivalStationId
        protected set
}
