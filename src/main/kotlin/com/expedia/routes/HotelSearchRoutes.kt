package com.expedia.routes
import com.expedia.models.*
import com.expedia.domain.HotelSearchService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.hotelSearchRouting() {
    // The search route should take as input:
    // 1. Location
    // 2. Checkin Date
    // 3. Checkout Date
    // 4. Price Range
    route("/search") {
        // For now, only implementing functionality to return a list of hotels filtered by location and ordered by rating
        post {
            val hotelSearchRequestParams = call.receive<HotelSearchRequest>()

            val hotelSearchService = HotelSearchService()

            val hotelSearchResults = hotelSearchService.getHotelsByLocation(hotelSearchRequestParams.location)

            call.respondText("Some hotels you might be interested in: ${hotelSearchResults.hotels}", status = HttpStatusCode.OK)
        }
    }
}