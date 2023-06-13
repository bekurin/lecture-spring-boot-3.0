package com.backend.core.support

import com.backend.core.config.DockerComposeContainersConfig
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(initializers = [DockerComposeContainersConfig.Companion.TestContainerInitializer::class])
class IntegrationTestBase {

    @Autowired
    protected lateinit var mvc: MockMvc

    @Autowired
    protected lateinit var objectMapper: ObjectMapper

//    protected val objectMapper: ObjectMapper = jacksonObjectMapper()
//        .setAnnotationIntrospector(
//            MarkerAnnotationIntroSpector() to jacksonObjectMapper().serializationConfig.annotationIntrospector
//        )
}
