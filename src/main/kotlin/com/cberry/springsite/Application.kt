package com.cberry.springsite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringSiteApplication

fun main(args: Array<String>) {
    runApplication<SpringSiteApplication>(*args)
}
