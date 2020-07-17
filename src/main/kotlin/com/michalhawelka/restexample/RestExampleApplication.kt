package com.michalhawelka.restexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestExampleApplication

fun main(args: Array<String>) {
	runApplication<RestExampleApplication>(*args)
}
