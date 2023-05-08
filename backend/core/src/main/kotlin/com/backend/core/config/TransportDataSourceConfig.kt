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
    basePackages = [TransportDataSourceConfig.TRANSPORT_BASE_PACKAGE],
    entityManagerFactoryRef = TransportDataSourceConfig.TRANSPORT_ENTITY_MANAGER_FACTORY_REF,
    transactionManagerRef = TransportDataSourceConfig.TRANSPORT_TRANSACTION_MANAGER_REF
)
class TransportDataSourceConfig {

    companion object {
        const val TRANSPORT_ENTITY_MANAGER = "transportEntityManager"
        const val TRANSPORT_DATA_SOURCE = "transportDataSource"
        const val TRANSPORT_BASE_PACKAGE = "com.backend.core.domain.transport"
        const val TRANSPORT_TRANSACTION_MANAGER_REF = "transportTransactionManager"
        const val TRANSPORT_ENTITY_MANAGER_FACTORY_REF = "transportEntityManagerFactory"
    }

    @Bean(name = [TRANSPORT_DATA_SOURCE])
    @ConfigurationProperties("spring.datasource.transport.write.hikari")
    fun writeDataSource(): DataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean(name = ["transportReadOnlyDataSource"])
    @ConfigurationProperties("spring.datasource.transport.read-only.hikari")
    fun readOnlyDataSource(): DataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean
    fun transportEntityManagerFactory(
        @Qualifier(TRANSPORT_DATA_SOURCE)
        transportDataSource: DataSource,
        jpaProperties: JpaProperties
    ): LocalContainerEntityManagerFactoryBean {
        return LocalContainerEntityManagerFactoryBean().apply {
            dataSource = transportDataSource
            persistenceUnitName = TRANSPORT_TRANSACTION_MANAGER_REF
            setPackagesToScan(AuthDataSourceConfig.AUTH_BASE_PACKAGE)
            setJpaPropertyMap(jpaProperties.properties)
        }
    }

    @Bean
    fun transportTransactionManager(
        @Qualifier(TRANSPORT_ENTITY_MANAGER_FACTORY_REF)
        transportEntityManagerFactory: LocalContainerEntityManagerFactoryBean
    ): PlatformTransactionManager {
        return JpaTransactionManager(
            transportEntityManagerFactory.`object`
                ?: throw NullPointerException("transportEntityManagerFactory cannot be null")
        )
    }
}
