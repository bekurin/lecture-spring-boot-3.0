package com.backend.core.domain.taxi.spot.repository

import com.backend.core.domain.taxi.spot.Spot
import org.springframework.data.jpa.repository.JpaRepository

interface SpotRepository : JpaRepository<Spot, Long>
