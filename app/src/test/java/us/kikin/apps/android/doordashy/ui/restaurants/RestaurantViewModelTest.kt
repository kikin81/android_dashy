package us.kikin.apps.android.doordashy.ui.restaurants

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import us.kikin.apps.android.doordashy.data.FakeTestRepository

@ExperimentalCoroutinesApi
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
    fun getRestaurantsNearMe() {
    }
}
