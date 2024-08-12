package com.expedia.models
import kotlinx.serialization.Serializable

@Serializable
data class Location (
    val id: String,
    val name: String,
)