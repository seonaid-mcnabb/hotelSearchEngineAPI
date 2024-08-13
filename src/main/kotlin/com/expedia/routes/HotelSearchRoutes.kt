package com.expedia.routes
import com.expedia.models.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*




private val location = Location("1", "Madrid")
private val review = Review("12", 10, "Absolutely Amazing, would go again!")

private val hotels = mutableListOf(
    Hotel("1", "Ritz Carlton", "Too expensive for u bitch", location, 50000, "www.ritzybitches.com", listOf(review), )
)
private val hotelSearchResponse = HotelSearchResponse(hotels)

fun Route.hotelSearchRouting() {
    // The search route should take as input:
    // 1. Location
    // 2. Checkin Date
    // 3. Checkout Date
    // 4. Price Range
    route("/search") {
        // The search post receives a hotel search request with the established params.
        post {
            val hotelSearchRequest = call.receive<HotelSearchRequest>()
            call.respondText("Received search request for location: ${hotelSearchRequest.location}")
        }
    }
}