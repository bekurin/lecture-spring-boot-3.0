package com.example.core.domain.member

import com.example.core.domain.BaseEntity
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
    var phone = phone
        protected set

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var state = state
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