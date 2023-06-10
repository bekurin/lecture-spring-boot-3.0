package com.backend.core.config

import org.junit.ClassRule
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.support.TestPropertySourceUtils
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.containers.wait.strategy.Wait
import java.io.File

@Configuration
class DockerComposeContainersConfig {
    companion object {
        @ClassRule
        val environment = DockerComposeContainer(File("./src/test/resources/docker-compose.yml"))
            .withExposedService(
                TestContainersType.MASTER.serviceName,
                TestContainersType.MASTER.port,
                Wait.forListeningPort()
            )

        init {
            environment.start()
        }

        private fun getServiceHostAndPortBy(type: TestContainersType): String {
            return "${
                environment.getServiceHost(
                    type.serviceName,
                    type.port
                )
            }:${environment.getServicePort(type.serviceName, type.port)}"
        }

        class TestContainerInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
            override fun initialize(applicationContext: ConfigurableApplicationContext) {
                TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                    applicationContext,
                    "spring.datasource.hikari.jdbc-url=" +
                            "jdbc:mysql://${getServiceHostAndPortBy(TestContainersType.MASTER)}/core",
                )
            }
        }
    }
}
