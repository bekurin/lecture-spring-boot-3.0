package com.backend.core.domain.repository

import com.backend.core.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<User, Long>
