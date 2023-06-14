package com.backend.core.support

import com.backend.core.config.DockerComposeContainersConfig
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
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

    protected fun setAuthorityToSecurityContextHolder(vararg roles: String): Boolean {
        return try {
            val authentication = SecurityContextHolder.getContext().authentication
            val authority = roles.map { role ->
                SimpleGrantedAuthority(role)
            }
            SecurityContextHolder.getContext().authentication =
                UsernamePasswordAuthenticationToken(authentication.principal, authentication.credentials, authority)
            true
        } catch (e: Exception) {
            false
        }
    }
}
