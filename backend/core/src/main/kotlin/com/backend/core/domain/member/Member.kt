package com.backend.core.domain.member

import com.backend.core.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Member(
        phone: String,
        state: ReservationState
) : BaseEntity() {
    @Column(nullable = false)
    var phone: String = phone
        protected set

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var state: ReservationState = state
        protected set
}

enum class ReservationState(
        private val description: String
) {
    DEFAULT("기본"),
    RESERVATION("예약"),
    BOARDING("탑승"),
    COMPLETE("완료")
}