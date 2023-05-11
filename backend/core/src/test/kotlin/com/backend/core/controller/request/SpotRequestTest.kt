package com.backend.core.controller.request

import com.backend.core.support.UnitTestBase
import jakarta.validation.Validation
import jakarta.validation.Validator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.*

class SpotRequestTest : UnitTestBase() {

    private val validator: Validator by lazy {
        Validation.buildDefaultValidatorFactory().validator
    }

    @Nested
    inner class `예외가 발생한다` {
        @Nested
        inner class `거점 생성 요청을 만들 때` {
            @ParameterizedTest
            @ValueSource(strings = ["", " "])
            fun `name 필드가 공백이라면`(name: String) {
                // given
                val givenRequest = of(name = name)

                // when
                val constraintViolations = validator.validate(givenRequest)

                // then
                assertThat(constraintViolations.size).isEqualTo(1)
            }

            @ParameterizedTest
            @CsvSource(
                value = [
                    "-1, 0",
                    "0, -1"
                ]
            )
            fun `Position 객체에 음수가 포함되면`(latitude: Double, longitude: Double) {
                // given
                val givenRequest = of(latitude = latitude, longitude = longitude)

                // when
                val constraintViolations = validator.validate(givenRequest)

                // then
                assertThat(constraintViolations.size).isEqualTo(1)
            }

            private fun of(
                name: String = UUID.randomUUID().toString(),
                latitude: Double = (0..100).random().toDouble(),
                longitude: Double = (0..100).random().toDouble()
            ): SpotRequest {
                return SpotRequest(name, PositionRequest(latitude, longitude))
            }
        }
    }
}
