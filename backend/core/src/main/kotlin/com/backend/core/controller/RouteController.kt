package com.backend.core.controller

import com.backend.core.controller.request.SpotRequest
import com.backend.core.controller.response.PagedResponse
import com.backend.core.controller.response.RouteResponse
import com.backend.core.service.RouteService
import com.backend.core.util.Constants
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/v1")
class RouteController(
    private val routeService: RouteService
) {

    @GetMapping("/routes/page/{page}")
    fun findAllPagedRoute(
        @PathVariable(required = true) page: Int = Constants.DEFAULT_PAGE,
        @RequestParam(required = true, defaultValue = Constants.DEFAULT_SIZE) size: Int
    ): PagedResponse<RouteResponse> {
        return routeService.findAllPagedRoute(page, size)
    }

    @PostMapping("/route")
    fun createRoute(
        @RequestBody @Valid request: List<SpotRequest>
    ): RouteResponse {
        return routeService.createRoute(request)
    }
}
