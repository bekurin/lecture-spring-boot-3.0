package com.example.core.domain.spot.repository

import com.example.core.domain.spot.Spot
import org.springframework.data.jpa.repository.JpaRepository

interface SpotRepository : JpaRepository<Spot, Long>