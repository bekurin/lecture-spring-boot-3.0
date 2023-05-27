package com.backend.core.domain

import com.backend.core.domain.BaseEntity
import converter.NameConverter
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity

@Entity
class Member(
    username: String,
    phone: String,
) : BaseEntity() {

    @Column(nullable = false)
    @Convert(converter = NameConverter::class)
    var username: String = username
        protected set

    @Column(nullable = false)
    var phone: String = phone
        protected set
}
