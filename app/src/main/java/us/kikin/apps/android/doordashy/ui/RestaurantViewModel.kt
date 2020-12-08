package us.kikin.apps.android.doordashy.ui

import androidx.lifecycle.ViewModel
import us.kikin.apps.android.doordashy.repository.RestaurantRepository
import javax.inject.Inject

class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel()
