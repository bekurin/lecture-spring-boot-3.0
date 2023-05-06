package com.backend.core.controller

import com.backend.core.controller.response.PagedResponse
import com.backend.core.controller.response.VehicleResponse
import com.backend.core.service.VehicleService
import com.backend.core.util.Constants
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
class VehicleController(
    private val vehicleService: VehicleService
) {
    @GetMapping("/vehicles/page/{page}")
    fun findAllPagedVehicle(
        @PathVariable page: Int,
        @RequestParam(required = true, defaultValue = Constants.DEFAULT_SIZE) size: Int
    ): PagedResponse<VehicleResponse> {
        return vehicleService.findAllPagedVehicle(page, size)
    }

    @PostMapping("/vehicle")
    fun createVehicle() {
        //TODO: 단일 운송 수단 등록 구현
    }
}
