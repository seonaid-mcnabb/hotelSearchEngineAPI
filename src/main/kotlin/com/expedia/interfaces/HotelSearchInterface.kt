package com.expedia.interfaces

import com.expedia.models.HotelSearchResponse

// To establish how the search service should behave
interface HotelSearchInterface {
    fun getHotelsByLocation(locationName: String?): HotelSearchResponse
}