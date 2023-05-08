package com.backend.core.config

enum class TestContainersType(
    val serviceName: String,
    val port: Int,
    private val description: String
) {
    MASTER("master", 3306, "쓰기 전용 DB 서비스명과 포트입니다"),
    READONLY("read-only", 3306, "읽기 전용 DB 서비스명과 포트입니다"),
    SECOND("second", 3306, "두번째 datasource 서비스명과 포트입니다")
}
