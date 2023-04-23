package com.backend.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoreApplication

fun main(args: Array<String>) {
	runApplication<com.backend.core.CoreApplication>(*args)
}