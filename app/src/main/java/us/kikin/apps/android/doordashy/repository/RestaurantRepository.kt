package us.kikin.apps.android.doordashy.repository

import us.kikin.apps.android.doordashy.model.Restaurant
import us.kikin.apps.android.doordashy.network.ApiService
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getNearestRestaurants(
        lat: Double,
        long: Double
    ): List<Restaurant> {
        val response = apiService.fetchNearbyRestaurantsForLatLong(lat, long)
        return response.map { Restaurant(it) }
    }
}
