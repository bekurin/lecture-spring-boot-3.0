package com.backend.core.domain.taxi.vehicle.repository

import com.backend.core.domain.taxi.vehicle.Vehicle
import org.springframework.data.jpa.repository.JpaRepository

interface VehicleRepository: JpaRepository<Vehicle, Long>
