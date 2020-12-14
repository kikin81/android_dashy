package us.kikin.apps.android.doordashy.data.source

import us.kikin.apps.android.doordashy.model.Restaurant
import us.kikin.apps.android.doordashy.network.ApiService
import javax.inject.Inject

class DefaultRestaurantRepository @Inject constructor(
    private val apiService: ApiService
) : RestaurantRepository {

    override suspend fun getNearestRestaurants(
        lat: Double,
        long: Double
    ): List<Restaurant> {
        val response = apiService.fetchNearbyRestaurantsForLatLong(lat, long)
        return response.map { Restaurant(it) }
    }
}
