package com.backend.core.service

import com.backend.core.controller.response.PagedResponse
import com.backend.core.controller.response.SpotResponse
import com.backend.core.domain.spot.Spot
import com.backend.core.domain.spot.repository.SpotRepository
import com.backend.core.util.getSortByIdDescPageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class SpotService(
    private val spotRepository: SpotRepository
) {

    @Transactional
    fun create(spot: Spot): Spot {
        spotRepository.save(spot)
        return spot
    }

    fun findAllPagedSpot(page: Int, size: Int): PagedResponse<SpotResponse> {
        val pageable = getSortByIdDescPageable(page, size)
        val spotList = spotRepository.findAll(pageable)
        return PagedResponse(spotList.map { SpotResponse(it) })
    }
}
