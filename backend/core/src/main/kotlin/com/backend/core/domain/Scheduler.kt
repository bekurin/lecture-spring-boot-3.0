package com.backend.core.domain.scheduler

import com.backend.core.domain.BaseEntity
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
