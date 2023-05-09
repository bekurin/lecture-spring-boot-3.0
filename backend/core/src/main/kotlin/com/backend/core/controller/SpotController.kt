package com.backend.core.controller

import com.backend.core.controller.request.SpotRequest
import com.backend.core.controller.response.PagedResponse
import com.backend.core.controller.response.SpotResponse
import com.backend.core.service.SpotService
import com.backend.core.util.Constants
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
class SpotController(
    private val spotService: SpotService
) {

    @PostMapping("/spot")
    fun createSpot(
        @Valid @RequestBody request: SpotRequest
    ): SpotRequest {
        return request
    }

    @PostMapping("/spots")
    fun createSpotList() {
        //TODO: 리스트로 입력을 받아 저장을 시도한다. 하나의 트랙잭션 안에서 저장을 시도하고, 하나라도 저장하지 못하면 모두 롤백한다.
    }

    @GetMapping("/spots/page/{page}")
    fun findAllPagedSpot(
        @PathVariable(required = true) page: Int = Constants.DEFAULT_PAGE,
        @RequestParam(required = true, defaultValue = Constants.DEFAULT_SIZE) size: Int
    ): PagedResponse<SpotResponse> {
        return spotService.findAllPagedSpot(page, size)
    }
}
