package com.example.core.config

enum class TestContainersType(
        val serviceName: String,
        val port: Int,
        private val description: String
) {
    MASTER_DB("master", 3306, "마스터 디비 서비스명과 포트입니다"),
}