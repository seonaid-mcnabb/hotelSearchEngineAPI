package com.expedia.models
import kotlinx.serialization.Serializable

@Serializable
data class HotelSearchResponse (
    val hotels: List<Hotel>
)