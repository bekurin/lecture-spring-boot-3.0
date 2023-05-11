package com.backend.core.service

import com.backend.core.controller.request.SpotRequest
import com.backend.core.controller.response.PagedResponse
import com.backend.core.controller.response.RouteResponse
import com.backend.core.domain.route.Route
import com.backend.core.domain.route.repository.RouteRepository
import com.backend.core.util.Pagination
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class RouteService(
    private val routeRepository: RouteRepository
) {

    @Transactional
    fun createRoute(spotList: List<SpotRequest>): RouteResponse {
        val route = Route(spotList.map { it.toEntity() }.toMutableList())
        val savedRoute = routeRepository.save(route)
        return RouteResponse(savedRoute)
    }

    fun findAllPagedRoute(page: Int, size: Int): PagedResponse<RouteResponse> {
        val pageable = Pagination.ofSortByIdDescOrThrow(page, size)
        val findRouteList = routeRepository.findAll(pageable)
        return PagedResponse(findRouteList.map { RouteResponse(it) })
    }
}
