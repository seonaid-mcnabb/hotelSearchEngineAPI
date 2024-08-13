import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class UserSearchInput(
    val location: String,
    val checkinDate: String,
    val checkoutDate: String,
    val priceRange: Array<Int>
)

object HotelSearchRequestMother {
    private val json = Json { prettyPrint = true }

    fun randomUserSearchInput(location: String, checkinDate: String, checkoutDate: String, priceRange: Array<Int>): String {
        val userSearchInput = UserSearchInput(location, checkinDate, checkoutDate, priceRange)
        return json.encodeToString(userSearchInput)
    }
}
