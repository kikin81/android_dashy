package us.kikin.apps.android.doordashy.data

import us.kikin.apps.android.doordashy.network.ApiService
import us.kikin.apps.android.doordashy.network.RestaurantDto

class FakeDataSource : ApiService {

    private val restaurant1 = RestaurantDto(
        0L,
        "McDonald's",
        "Fast Food",
        "",
        "2 hrs",
        3
    )

    private val restaurant2 = RestaurantDto(
        1L,
        "The Melt",
        "Burgers",
        "",
        "Closed",
        3
    )

    private val restaurants = listOf(restaurant1, restaurant2)

    override suspend fun fetchNearbyRestaurantsForLatLong(
        lat: Double,
        long: Double
    ): List<RestaurantDto> = restaurants

    override suspend fun fetchRestaurantById(id: Long): RestaurantDto? =
        restaurants.firstOrNull { it.id == id }
}
