package com.backend.core.domain

import jakarta.persistence.Entity

@Entity
class Train(
    name: String,
    capacity: Int,
) : BaseEntity() {
}
