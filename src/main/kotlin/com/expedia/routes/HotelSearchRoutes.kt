package com.expedia.routes
import com.expedia.models.Hotel
import com.expedia.models.Location
import com.expedia.models.Review
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*




private val location = Location("1", "Madrid")
private val review = Review("12", 10, "Absolutely Amazing, would go again!")

private val hotels = mutableListOf(
    Hotel("1", "Ritz Carlton", "Very expensive", location, 5000, "www.google.com", listOf(review), )
)

fun Route.hotelSearchRouting() {
    route("/search") {
        get {
            if (hotels.isNotEmpty()) {
                call.respond(hotels)
            } else {
                call.respondText("No hotels found with your search criteria", status= HttpStatusCode.OK)
            }
        }
    }
}