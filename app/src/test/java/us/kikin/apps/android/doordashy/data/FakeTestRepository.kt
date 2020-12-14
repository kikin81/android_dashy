package us.kikin.apps.android.doordashy.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import us.kikin.apps.android.doordashy.data.source.RestaurantRepository
import us.kikin.apps.android.doordashy.model.Restaurant

@ExperimentalCoroutinesApi
class FakeTestRepository : RestaurantRepository {

    var restaurantServiceData: LinkedHashMap<Long, Restaurant> = LinkedHashMap()

    override suspend fun getNearestRestaurants(lat: Double, long: Double): List<Restaurant> {
        return restaurantServiceData.values.toList()
    }
}
