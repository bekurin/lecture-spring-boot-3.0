package com.backend.core.controller

import com.backend.core.support.IntegrationTestBase
import org.junit.jupiter.api.Test

class HelloControllerTest : IntegrationTestBase() {

    @Test
    fun test() {
        val dto = HelloDto("홍길동", "01011112222")

        val result = objectMapper.writeValueAsString(dto)
        println()
    }
}
