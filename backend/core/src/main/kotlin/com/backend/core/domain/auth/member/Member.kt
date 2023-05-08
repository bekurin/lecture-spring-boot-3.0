package com.backend.core.domain.auth.member

import com.backend.core.domain.BaseEntity
import converter.NameConverter
import jakarta.persistence.*

@Entity
class Member(
    username: String,
    phone: String,
    state: ReservationState
) : BaseEntity() {

    @Column(nullable = false)
    @Convert(converter = NameConverter::class)
    var username: String = username
        protected set

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
