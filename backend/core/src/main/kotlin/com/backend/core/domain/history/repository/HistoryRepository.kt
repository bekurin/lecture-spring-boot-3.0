package com.backend.core.domain.history.repository

import com.backend.core.domain.history.History
import org.springframework.data.jpa.repository.JpaRepository

interface HistoryRepository: JpaRepository<History, Long>
