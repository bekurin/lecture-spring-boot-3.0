package com.backend.core.domain

import jakarta.persistence.Entity

@Entity
class Scheduler(
    routeId: Long,
    dayOfWeek: String
) : BaseEntity() {

    var routeId: Long = routeId
        protected set

    var dayOfWeek: String = dayOfWeek
        protected set
}
