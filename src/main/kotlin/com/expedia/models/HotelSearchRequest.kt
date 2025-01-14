package com.expedia.models
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate

// Necessary to implement because the serializer functionality does not currently work for LocalDate type
object LocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        return LocalDate.parse(decoder.decodeString())
    }
}

// The search request input currently allows any combination of the following params (hence, making them nullable)
@Serializable
data class HotelSearchRequest(
    val location: String? = null,
    @Serializable(with = LocalDateSerializer::class)
    val checkinDate: LocalDate? = null,
    @Serializable(with = LocalDateSerializer::class)
    val checkoutDate: LocalDate? = null,
    val priceRange: Array<Int>? = null
)