package com.backend.core.domain

import converter.NameConverter
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity

@Entity
class User(
    name: String,
    phone: String,
    token: String,
) : BaseEntity() {

    @Column(nullable = false)
    @Convert(converter = NameConverter::class)
    var name: String = name
        protected set

    @Column(nullable = false)
    var phone: String = phone
        protected set

    var token: String = token
        protected set
}
