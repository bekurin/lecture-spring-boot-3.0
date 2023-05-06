package com.backend.core.util

import com.backend.core.exception.ClientBadRequestException
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort


object Pagination {
    fun ofSortByIdDescOrThrow(page: Int, size: Int): PageRequest {
        validatePageRequest(page, size)
        return PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"))
    }

    private fun validatePageRequest(page: Int, size: Int) {
        if (page < 0) {
            throw ClientBadRequestException("page는 0 미만일 수 없습니다")
        }
        if (size < 1) {
            throw ClientBadRequestException("size는 0 이하일 수 없습니다")
        }
    }
}
