package us.kikin.apps.android.doordashy.ui.restaurants

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import us.kikin.apps.android.doordashy.data.FakeTestRepository

class RestaurantViewModelTest {

    @get:Rule
    var instantExecutor = InstantTaskExecutorRule()

    private lateinit var viewModel: RestaurantViewModel
    private lateinit var repository: FakeTestRepository

    @Before
    fun setupViewModel() {
        repository = FakeTestRepository()
        viewModel = RestaurantViewModel(repository)
    }

    @Test
    fun getRestaurantsNearMe_LoadingEvent() {
        // When getting restaurants near me

        // Then the loading event is triggered
    }
}
