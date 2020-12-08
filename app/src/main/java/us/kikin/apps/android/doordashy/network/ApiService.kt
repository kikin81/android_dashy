package us.kikin.apps.android.doordashy.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("restaurant")
    suspend fun fetchNearbyRestaurantsForLatLong(
        @Query("lat") lat: Long,
        @Query("lng") long: Long
    ): RestaurantSearchResponse

    @GET("restaurant/{restaurant_id}")
    suspend fun fetchRestaurantById(@Path("restaurant_id") id: Long): RestaurantDto
}
