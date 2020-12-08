package us.kikin.apps.android.doordashy.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("restaurant")
    suspend fun fetchNearbyRestaurantsForLatLong(
        @Query("lat") lat: Double,
        @Query("lng") long: Double
    ): List<RestaurantDto>

    @GET("restaurant/{restaurant_id}")
    suspend fun fetchRestaurantById(@Path("restaurant_id") id: Long): RestaurantDto
}
