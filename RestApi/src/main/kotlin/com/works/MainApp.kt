package com.works

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableJpaAuditing
class RestApiApplication

fun main(args: Array<String>) {
    runApplication<RestApiApplication>(*args)
}
