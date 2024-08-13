package com.expedia

import HotelSearchRequestMother
import com.expedia.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import kotlin.test.*


class ApplicationTest {
    @Test
    fun testHotelSearchEngineAPI() = testApplication {
        application { configureRouting(); configureSerialization() }
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hotel Search Engine API by Seonaid McNabb", bodyAsText())
        }

        val mockHotelSearchRequest = HotelSearchRequestMother.randomUserSearchInput(
            location = "Madrid",
            checkinDate = "2024-12-01",
            checkoutDate = "2024-12-14",
            priceRange = arrayOf(100, 200)
        )


        val response = client.post("/search"){
            contentType(ContentType.Application.Json)
            setBody(mockHotelSearchRequest)
        }

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Received search request for location: Madrid", response.bodyAsText())
    }
}
