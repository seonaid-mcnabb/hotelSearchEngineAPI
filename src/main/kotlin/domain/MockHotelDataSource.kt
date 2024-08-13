package domain

import com.expedia.models.Hotel
import com.expedia.models.Location
import com.expedia.models.Review

class MockHotelDataSource {
    val hotels: List<Hotel>

    init {
        val location1 = Location("1", "Paris")
        val location2 = Location("2", "New York")

        val goodMockReviews = listOf(
            Review(
                id = "1",
                rating = 5,
                comment = "Excellent stay! The room was clean, and the service was top-notch."
            ),
            Review(
                id = "2",
                rating = 5,
                comment = "Incredible."
            ),
            Review(
                id = "3",
                rating = 5,
                comment = "Perfect. No complaints!"
            )
        )

        val badMockReviews = listOf(
            Review(
                id = "1",
                rating = 1,
                comment = "Terrible stay. The room was dirty, and the service was rude. I would not recommend this hotel."
            ),
            Review(
                id = "2",
                rating = 2,
                comment = "Not great. The room was small and outdated. The staff was unhelpful and the amenities were lacking."
            ),
            Review(
                id = "3",
                rating = 1,
                comment = "Very disappointing. The hotel was noisy and the beds were uncomfortable. I regretted staying here."
            )
        )

        val mediocreMockReviews = listOf(
            Review(
                id = "3",
                rating = 4,
                comment = "Good value for the price. The room was clean and comfortable, though there were some minor issues like a slow Wi-Fi connection."
            ),
            Review(
                id = "4",
                rating = 3,
                comment = "The hotel was fine for a short stay. The staff was polite, but the overall experience felt a bit underwhelming. Could use some updates."
            ),
            Review(
                id = "5",
                rating = 4,
                comment = "Decent hotel with basic amenities. The stay was pleasant, though there were some small inconveniences such as a lack of parking spaces."
            )
        )

        hotels = listOf(
            // Paris Hotels
            Hotel("1", "Hotel Paris 1", "A great hotel in Paris", location1, 200, "image1.jpg", goodMockReviews),
            Hotel("2", "Hotel Paris 2", "Another great hotel in Paris", location1, 250, "image2.jpg", goodMockReviews),
            Hotel("3", "Hotel Paris 3", "Comfortable and convenient in Paris", location1, 180, "image3.jpg", mediocreMockReviews),
            Hotel("4", "Hotel Paris 4", "Average stay in Paris", location1, 220, "image4.jpg", mediocreMockReviews),
            Hotel("5", "Hotel Paris 5", "Not recommended in Paris", location1, 210, "image5.jpg", badMockReviews),
            Hotel("6", "Hotel Paris 6", "Disappointing experience in Paris", location1, 230, "image6.jpg", badMockReviews),

            // New York Hotels
            Hotel("7", "Hotel NYC 1", "A great hotel in New York", location2, 300, "image7.jpg", goodMockReviews),
            Hotel("8", "Hotel NYC 2", "Another great hotel in New York", location2, 320, "image8.jpg", goodMockReviews),
            Hotel("9", "Hotel NYC 3", "Comfortable and convenient in New York", location2, 280, "image9.jpg", mediocreMockReviews),
            Hotel("10", "Hotel NYC 4", "Average stay in New York", location2, 290, "image10.jpg", mediocreMockReviews),
            Hotel("11", "Hotel NYC 5", "Not recommended in New York", location2, 310, "image11.jpg", badMockReviews),
            Hotel("12", "Hotel NYC 6", "Disappointing experience in New York", location2, 330, "image12.jpg", badMockReviews)
        )
    }
}
