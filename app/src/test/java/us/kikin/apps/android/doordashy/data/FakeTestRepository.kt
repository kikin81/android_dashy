package us.kikin.apps.android.doordashy.data

import androidx.lifecycle.MutableLiveData
import us.kikin.apps.android.doordashy.data.source.RestaurantRepository
import us.kikin.apps.android.doordashy.model.Restaurant

class FakeTestRepository : RestaurantRepository {

    var restaurantServiceData: LinkedHashMap<String, Restaurant> = LinkedHashMap()
    private val observableRestaurants = MutableLiveData<List<Restaurant>>()

    override suspend fun getNearestRestaurants(lat: Double, long: Double): List<Restaurant> {
        return restaurantServiceData.values.toList()
    }
}
