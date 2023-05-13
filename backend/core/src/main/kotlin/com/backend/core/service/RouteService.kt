package com.backend.core.service

import com.backend.core.controller.request.SpotRequest
import com.backend.core.controller.response.PagedResponse
import com.backend.core.controller.response.RouteResponse
import com.backend.core.domain.route.Route
import com.backend.core.domain.route.repository.RouteRepository
import com.backend.core.util.Pagination
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

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

    fun exportToExcel() {
        val workbook = HSSFWorkbook()
        val sheet = workbook.createSheet("경로 현황")

        sheet.createRow(0).createCell(0).setCellValue(LocalDateTime.now())
        sheet.createRow(1).createCell(1).setCellValue("안녕")
        sheet.createRow(2).createCell(2).setCellValue("이거 되는거야?")
        sheet.createRow(3).createCell(3).setCellValue(12315.0)

        workbook.write()

    }
}
