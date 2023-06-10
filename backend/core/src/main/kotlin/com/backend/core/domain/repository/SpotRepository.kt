package com.backend.core.domain.repository

import com.backend.core.domain.Spot
import org.springframework.data.jpa.repository.JpaRepository

interface SpotRepository : JpaRepository<Spot, Long>
