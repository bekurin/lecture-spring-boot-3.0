package com.backend.core.domain.auth.member.repository

import com.backend.core.domain.auth.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long>
