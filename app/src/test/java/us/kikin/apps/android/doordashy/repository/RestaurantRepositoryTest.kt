package us.kikin.apps.android.doordashy.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test
import us.kikin.apps.android.doordashy.data.FakeDataSource
import us.kikin.apps.android.doordashy.data.source.DefaultRestaurantRepository
import us.kikin.apps.android.doordashy.model.Restaurant

@ExperimentalCoroutinesApi
class RestaurantRepositoryTest {

    private val mcD = Restaurant(
        0L,
        "McDonald's",
        "Fast Food",
        "",
        "Closed",
        3
    )

    private val restaurantList = listOf(mcD).sortedBy { it.id }

    private lateinit var restaurantRepository: DefaultRestaurantRepository

    @Before
    fun createRepository() {
        restaurantRepository = DefaultRestaurantRepository(FakeDataSource())
    }

    @Test
    fun getNearestRestaurants_requestsAllRestaurants() = runBlockingTest {
        val restaurants = restaurantRepository.getNearestRestaurants(0.0, 0.0)

        assertThat(restaurants, IsEqual(restaurantList))
    }
}
