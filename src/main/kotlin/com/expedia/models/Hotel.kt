package com.expedia.models
import kotlinx.serialization.Serializable


//Data object to be returned to the user in a search
@Serializable
data class Hotel (
    val id: String,
    val name: String,
    val description: String,
    val location: Location,
    val totalPrice: Int,
    val image: String,
    val reviews: List<Review>
)