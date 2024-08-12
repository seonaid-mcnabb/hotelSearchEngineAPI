package com.expedia.models
import kotlinx.serialization.Serializable

@Serializable
data class Review (
    val id: String,
    val rating: Int,
    val comment: String,
)