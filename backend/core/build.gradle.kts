import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val testcontainersVersion: String = "1.17.6"
val mysqlConnectorVersion: String = "8.0.32"
val querydslVersion: String = "5.0.0"

plugins {
	id("org.springframework.boot") version "3.0.5"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.asciidoctor.convert") version "2.4.0"
	kotlin("jvm") version "1.7.22"
	kotlin("kapt") version "1.7.10"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.jpa") version "1.7.22"
}

group = "com.backend.core"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

val snippetsDir by extra {file("build/generated-snippets")}
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux") {
		exclude("org.springframework.boot:spring-boot-starter-reactor-netty")
	}
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.mysql:mysql-connector-j")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("org.springframework.security:spring-security-test")

	// testsContainer
	testImplementation("org.testcontainers:testcontainers:$testcontainersVersion")

	// querydsl
	implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")
	kapt("com.querydsl:querydsl-apt:$querydslVersion:jakarta")

	// local library
	implementation(files("libs/obsure-1.0-SNAPSHOT.jar"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

noArg {
	annotation("jakarta.persistence.Entity")
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {
	outputs.dir(snippetsDir)
}

tasks.register<Test>("integrationTest") {
	filter {
		includeTestsMatching("*IT")
	}
}

tasks.register<Test>("unitTest") {
	filter {
		includeTestsMatching("Test")
	}
}

tasks.asciidoctor {
	inputs.dir(snippetsDir)
	dependsOn(tasks.test)
}
