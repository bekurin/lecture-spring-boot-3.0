package com.backend.core.controller.response

import org.springframework.data.domain.Page

data class PagedResponse<T>(
    val totalCount: Long,
    val currentPage: Int,
    val currentSize: Int,
    val nextPage: Int,
    val hasNext: Boolean,
    val hasPresent: Boolean,
    val contents: List<T>
) {
    constructor(page: Page<T>) : this(
        totalCount = page.totalElements,
        currentPage = page.number,
        currentSize = page.size,
        nextPage = page.number + 1,
        hasNext = page.hasNext(),
        hasPresent = page.hasPrevious(),
        contents = page.content
    )
}
