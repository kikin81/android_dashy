package us.kikin.apps.android.doordashy.ui.restaurants

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import us.kikin.apps.android.doordashy.launchFragmentInHiltContainer

@MediumTest
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class RestaurantListFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun restaurantsNearMe_DisplayedInUi() {
        launchFragmentInHiltContainer<RestaurantListFragment>(null)
    }
}
