package us.kikin.apps.android.doordashy.ui.restaurants

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RestaurantViewModelTest {

    @get:Rule
    var instantExecutor = InstantTaskExecutorRule()

    private lateinit var viewModel: RestaurantViewModel

    @Before
    fun setupViewModel() {
    }

    @Test
    fun getRestaurantsNearMe_LoadingEvent() {
        // When getting restaurants near me

        // Then the loading event is triggered
    }
}
