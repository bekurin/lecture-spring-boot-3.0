package com.backend.core.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = [AuthDataSourceConfig.AUTH_BASE_PACKAGE],
    entityManagerFactoryRef = AuthDataSourceConfig.AUTH_ENTITY_MANAGER_FACTORY_REF,
    transactionManagerRef = AuthDataSourceConfig.AUTH_TRANSACTION_MANAGER_REF
)
class AuthDataSourceConfig {
    companion object {
        const val AUTH_ENTITY_MANAGER = "authEntityManager"
        const val AUTH_DATA_SOURCE = "authDataSource"
        const val AUTH_BASE_PACKAGE = "com.backend.core.domain.auth"
        const val AUTH_TRANSACTION_MANAGER_REF = "authTransactionManager"
        const val AUTH_ENTITY_MANAGER_FACTORY_REF = "authEntityManagerFactory"
    }

    @Bean
    @ConfigurationProperties("spring.datasource.auth.master.hikari")
    fun authDataSource(): DataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean
    fun authEntityManagerFactory(
        @Qualifier(AUTH_DATA_SOURCE)
        authDataSource: DataSource,
        jpaProperties: JpaProperties
    ): LocalContainerEntityManagerFactoryBean {
        return LocalContainerEntityManagerFactoryBean().apply {
            dataSource = authDataSource
            persistenceUnitName = AUTH_TRANSACTION_MANAGER_REF
            setPackagesToScan(AUTH_BASE_PACKAGE)
            setJpaPropertyMap(jpaProperties.properties)
        }
    }

    @Bean
    fun authTransactionManager(
        @Qualifier(AUTH_ENTITY_MANAGER_FACTORY_REF)
        authEntityManagerFactory: LocalContainerEntityManagerFactoryBean
    ): PlatformTransactionManager {
        return JpaTransactionManager(
            authEntityManagerFactory.`object` ?: throw NullPointerException("authEntityManagerFactory cannot be null")
        )
    }
}
