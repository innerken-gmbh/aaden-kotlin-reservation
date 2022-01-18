package com.innerken.reservation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling

open class HotpotReservationApplication

fun main(args: Array<String>) {
    runApplication<HotpotReservationApplication>(*args)
}