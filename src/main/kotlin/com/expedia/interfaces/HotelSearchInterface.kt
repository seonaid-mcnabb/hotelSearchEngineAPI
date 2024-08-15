package com.expedia.interfaces

import com.expedia.models.HotelSearchRequest
import com.expedia.models.HotelSearchResponse

// To establish how the search service should behave
interface HotelSearchInterface {
    fun getHotelsFromUserInput(searchParameters: HotelSearchRequest): HotelSearchResponse
}