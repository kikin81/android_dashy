package us.kikin.apps.android.doordashy.data

import us.kikin.apps.android.doordashy.network.ApiService
import us.kikin.apps.android.doordashy.network.RestaurantDto

class FakeDataSource : ApiService {

    private val mcD = RestaurantDto(
        0L,
        "McDonald's",
        "Fast Food",
        "",
        "Closed",
        3
    )

    override suspend fun fetchNearbyRestaurantsForLatLong(
        lat: Double,
        long: Double
    ): List<RestaurantDto> =
        listOf(mcD)

    override suspend fun fetchRestaurantById(id: Long): RestaurantDto {
        TODO("Not yet implemented")
    }
}
