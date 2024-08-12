package com.expedia.plugins

import com.expedia.routes.hotelSearchRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hotel Search Engine API by Seonaid McNabb")
        }
        hotelSearchRouting()
    }
}
