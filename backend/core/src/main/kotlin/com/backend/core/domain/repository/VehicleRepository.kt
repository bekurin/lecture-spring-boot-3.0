package com.backend.core.domain.vehicle.repository

import com.backend.core.domain.vehicle.Vehicle
import org.springframework.data.jpa.repository.JpaRepository

interface VehicleRepository: JpaRepository<Vehicle, Long>
