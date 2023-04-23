package com.backend.core.support

import com.example.core.config.DockerComposeContainersConfig
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = [DockerComposeContainersConfig.Companion.TestContainerInitializer::class])
class RepositoryTestBase {
    @Autowired
    protected lateinit var entityManager: EntityManager
}