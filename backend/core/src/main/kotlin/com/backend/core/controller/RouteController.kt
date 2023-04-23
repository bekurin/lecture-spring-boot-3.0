package com.backend.core.controller

import com.backend.core.controller.request.SpotRequest
import com.backend.core.controller.response.PagedResponse
import com.backend.core.controller.response.RouteResponse
import com.backend.core.service.RouteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
class RouteController(
    private val routeService: RouteService
) {

    @GetMapping("/routes/page/{page}")
    fun findAllPagedRoute(
        @PathVariable page: Int,
        @RequestParam size: Int,
    ): PagedResponse<RouteResponse> {
        return routeService.findAllPagedRoute(page, size)
    }

    @PostMapping("/route")
    fun createRoute(
        @RequestBody spotRequestList: List<SpotRequest>
    ): RouteResponse {
        return routeService.createRoute(spotRequestList)
    }
}