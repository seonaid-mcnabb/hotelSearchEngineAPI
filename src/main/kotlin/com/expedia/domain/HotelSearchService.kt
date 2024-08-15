package com.expedia.domain

import com.expedia.interfaces.HotelSearchInterface
import com.expedia.models.HotelSearchRequest
import com.expedia.models.HotelSearchResponse

class HotelSearchService: HotelSearchInterface {

    override fun getHotelsFromUserInput(searchParameters: HotelSearchRequest): HotelSearchResponse {
        val hotels =  HotelFilter.filterAndSortHotels(searchParameters)
        return HotelSearchResponse(hotels)
    }
}