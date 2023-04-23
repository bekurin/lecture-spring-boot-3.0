package com.backend.core.service

import com.backend.core.controller.request.SpotRequest
import com.backend.core.controller.response.PagedResponse
import com.backend.core.controller.response.RouteResponse
import com.backend.core.domain.route.Route
import com.backend.core.domain.route.repository.RouteRepository
import com.backend.core.domain.spot.Spot
import com.backend.core.exception.ClientBadRequestException
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class RouteService(
    private val routeRepository: RouteRepository
) {

    @Transactional
    fun createRoute(spotList: List<SpotRequest>): RouteResponse {
        val route = Route(spotList.map { Spot(it.name, position = it.position) }.toMutableList())
        val savedRoute = routeRepository.save(route)
        return RouteResponse(savedRoute)
    }

    fun findAllPagedRoute(page: Int, size: Int): PagedResponse<RouteResponse> {
        validatePayload(page, size)
        val pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"))
        val findRouteList = routeRepository.findAll(pageable)
        return PagedResponse(findRouteList.map { RouteResponse(it) })
    }

    private fun validatePayload(page: Int, size: Int) {
        if (size < 1) {
            throw ClientBadRequestException("size는 1보다 작을 수 없습니다")
        }
        if (page < 0) {
            throw ClientBadRequestException("page는 0보다 작을 수 없습니다")
        }
    }
}
