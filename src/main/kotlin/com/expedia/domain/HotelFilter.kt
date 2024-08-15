package com.expedia.domain

import com.expedia.models.Hotel
import com.expedia.models.HotelSearchRequest
import com.expedia.models.Review

object HotelFilter {
    private val hotels = MockHotelDataSource().hotels

    fun filterAndSortHotels(
        requestParameters: HotelSearchRequest,
    ): List<Hotel> {
        // Filter hotels by the input location
        val hotelsFilteredByLocation =
            hotels.filter { it.location.name.equals(requestParameters.location, ignoreCase = true) }

        // Sort hotels by their average review rating
        val hotelsSortedByRating =
            hotelsFilteredByLocation.sortedByDescending { calculateHotelsAverageRating(it.reviews) }

        // Return the sorted list of hotels for the user to review
        return hotelsSortedByRating
    }

    // Calculate the average rating of a hotel's reviews
    private fun calculateHotelsAverageRating(reviews: List<Review>): Double {
        return if (reviews.isEmpty()) 0.0 else reviews.map { it.rating }.average()
    }
}

