package com.expedia.domain

import com.expedia.interfaces.HotelSearchInterface
import com.expedia.models.HotelSearchResponse
import com.expedia.models.Review

class HotelSearchService: HotelSearchInterface {

    override fun getHotelsByLocation(locationName: String?): HotelSearchResponse {

        val hotels = MockHotelDataSource().hotels
        val filteredHotels =  hotels.filter { it.location.name.equals(locationName, ignoreCase = true) }

        //Function to order by rating
        val hotelsSortedByRating = filteredHotels.sortedByDescending { calculateHotelsAverageRating(it.reviews) }

        return HotelSearchResponse(hotelsSortedByRating)
    }

    // Function to calculate the average rating of a hotel's reviews
    private fun calculateHotelsAverageRating(reviews: List<Review>): Double {
        return if (reviews.isEmpty()) 0.0 else reviews.map { it.rating }.average()
    }
}