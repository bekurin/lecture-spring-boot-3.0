package com.backend.core.controller

import com.backend.core.util.Marker
import constant.ProcessType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun getHello(): HelloDto {
        return HelloDto("홍길동", "01011112222")
    }
}

data class HelloDto(
    @field:Marker(ProcessType.NAME)
    val name: String,
    @field:Marker(ProcessType.PASSWORD)
    val phone: String,
)
