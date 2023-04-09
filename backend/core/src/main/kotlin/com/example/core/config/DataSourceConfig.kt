package com.example.core.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.master.hikari")
    fun masterDataSource(): DataSource {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource::class.java)
                .build()
    }

    @Bean(name = ["slaveDataSource"])
    @ConfigurationProperties("spring.datasource.slave.hikari")
    fun slaveDataSource(): DataSource {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource::class.java)
                .build()
    }
}