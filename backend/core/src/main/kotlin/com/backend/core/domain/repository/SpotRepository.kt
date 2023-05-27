package com.backend.core.domain.spot.repository

import com.backend.core.domain.spot.Spot
import org.springframework.data.jpa.repository.JpaRepository

interface SpotRepository : JpaRepository<Spot, Long>
