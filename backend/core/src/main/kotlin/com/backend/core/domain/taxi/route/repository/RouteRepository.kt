package com.backend.core.domain.taxi.route.repository

import com.backend.core.domain.taxi.route.Route
import org.springframework.data.jpa.repository.JpaRepository

interface RouteRepository: JpaRepository<Route, Long>
