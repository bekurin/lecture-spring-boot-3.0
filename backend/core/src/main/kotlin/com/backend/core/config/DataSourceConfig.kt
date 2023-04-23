package com.backend.core.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

    //TODO: TransactionalContext의 readOnly 관련 함수를 디버깅하여 writer, readonly가 정상적으로 동작하는지 확인해야한다.
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.write.hikari")
    fun writeDataSource(): DataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean(name = ["readOnlyDataSource"])
    @ConfigurationProperties("spring.datasource.read-only.hikari")
    fun readOnlyDataSource(): DataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }
}