package com.example.core.domain.vehicle.repository

import com.example.core.domain.vehicle.Vehicle
import org.springframework.data.jpa.repository.JpaRepository

interface VehicleRepository: JpaRepository<Vehicle, Long>