package com.backend.core.util

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort


object Pagination {
    fun ofSortByIdDesc(page: Int, size: Int): PageRequest {
        return PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"))
    }

    fun ofSortByProperties(
        page: Int,
        size: Int,
        direction: Sort.Direction = Sort.Direction.DESC,
        vararg properties: String
    ): PageRequest {
        return PageRequest.of(page, size, direction, *properties)
    }
}
