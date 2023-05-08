package com.backend.core.domain.taxi.history.repository

import com.backend.core.domain.taxi.history.History
import org.springframework.data.jpa.repository.JpaRepository

interface HistoryRepository: JpaRepository<History, Long>
