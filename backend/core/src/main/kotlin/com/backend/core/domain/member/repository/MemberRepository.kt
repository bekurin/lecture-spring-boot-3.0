package com.backend.core.domain.member.repository

import com.backend.core.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long>