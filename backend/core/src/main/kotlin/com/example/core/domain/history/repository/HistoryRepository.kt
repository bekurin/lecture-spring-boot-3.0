package com.example.core.domain.history.repository

import com.example.core.domain.history.History
import org.springframework.data.jpa.repository.JpaRepository

interface HistoryRepository: JpaRepository<History, Long>