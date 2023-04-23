package com.backend.core.config

enum class TestContainersType(
    val serviceName: String,
    val port: Int,
    private val description: String
) {
    WRITE("write", 3306, "쓰기 전용 DB 서비스명과 포트입니다"),
    READONLY("read-only", 3306, "읽기 전용 DB 서비스명과 포트입니다")
}