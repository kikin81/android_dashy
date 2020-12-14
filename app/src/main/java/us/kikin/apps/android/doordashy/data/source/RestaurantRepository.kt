package us.kikin.apps.android.doordashy.data.source

import us.kikin.apps.android.doordashy.model.Restaurant

interface RestaurantRepository {

    suspend fun getNearestRestaurants(
        lat: Double,
        long: Double
    ): List<Restaurant>
}
