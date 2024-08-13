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

    fun randomUserSearchInput(): String {
        val userSearchInput = UserSearchInput( location = "Paris",
            checkinDate = "2024-12-01",
            checkoutDate = "2024-12-14",
            priceRange = arrayOf(100, 200))
        return json.encodeToString(userSearchInput)
    }
}
