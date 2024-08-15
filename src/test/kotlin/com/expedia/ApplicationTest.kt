package com.expedia

import HotelSearchRequestMother
import com.expedia.domain.HotelFilter
import com.expedia.models.HotelSearchRequest
import com.expedia.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import java.time.LocalDate
import kotlin.test.*


class ApplicationTest {
    @Test
    fun testHotelSearchEngineAPIRespondsWith200() = testApplication {
        application { configureRouting(); configureSerialization() }
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val mockHotelSearchRequest = HotelSearchRequestMother.randomUserSearchInput()

        val response = client.post("/search"){
            contentType(ContentType.Application.Json)
            setBody(mockHotelSearchRequest)
        }
        assertEquals(HttpStatusCode.OK, response.status)
    }
}

class HotelFilterTest {
    @Test
    fun testHotelsAreSortedByReviewRating() {
        //Given
        val searchRequest = HotelSearchRequest(
            location = "Paris",
            checkinDate = LocalDate.now(),
            checkoutDate = LocalDate.now().plusDays(2),
            priceRange = arrayOf(50, 250)
        )

        //When
        val sortedHotels = HotelFilter.filterAndSortHotels(searchRequest)

        //Then
        assertEquals("Hotel Paris 1", sortedHotels[0].name)  // Highest rating
        assertEquals("Hotel Paris 2", sortedHotels[1].name)  // Second highest rating
        assertEquals("Hotel Paris 3", sortedHotels[2].name)  // Third highest rating
        assertEquals("Hotel Paris 4", sortedHotels[3].name)  // 4th highest rating
    }
}