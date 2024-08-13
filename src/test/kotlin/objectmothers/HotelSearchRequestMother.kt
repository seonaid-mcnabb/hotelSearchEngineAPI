import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class UserSearchInput(
    val location: String?  = null,
    val checkinDate: String?  = null,
    val checkoutDate: String? = null,
    val priceRange: Array<Int>? = null
)

object HotelSearchRequestMother {
    private val json = Json { prettyPrint = true }

    fun randomUserSearchInputWithAllParams(location: String, checkinDate: String, checkoutDate: String, priceRange: Array<Int>): String {
        val userSearchInput = UserSearchInput(location, checkinDate, checkoutDate, priceRange)
        return json.encodeToString(userSearchInput)
    }

    fun randomUserSearchInputWithOnlyLocation(location: String): String {
        val userSearchInput = UserSearchInput(location)
        return json.encodeToString(userSearchInput)
    }
}
