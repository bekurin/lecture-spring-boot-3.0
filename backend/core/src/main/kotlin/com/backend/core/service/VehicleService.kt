package com.backend.core.service

import com.backend.core.controller.response.PagedResponse
import com.backend.core.controller.response.VehicleResponse
import com.backend.core.domain.vehicle.Vehicle
import com.backend.core.domain.vehicle.repository.VehicleRepository
import com.backend.core.util.Pagination
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class VehicleService(
    private val vehicleRepository: VehicleRepository
) {

    @Transactional
    fun create(vehicle: Vehicle) {
        vehicleRepository.save(vehicle)
    }

    fun findAllPagedVehicle(page: Int, size: Int): PagedResponse<VehicleResponse> {
        val pageable = Pagination.ofSortByIdDesc(page, size)
        val vehicleList = vehicleRepository.findAll(pageable)
        return PagedResponse(vehicleList.map { VehicleResponse(it) })
    }
}
