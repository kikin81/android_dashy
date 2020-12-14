package us.kikin.apps.android.doordashy.ui.restaurantdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import us.kikin.apps.android.doordashy.data.source.RestaurantRepository
import us.kikin.apps.android.doordashy.model.Restaurant

class RestaurantDetailViewModel @ViewModelInject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _data = MutableLiveData<Restaurant>()
    val data: LiveData<Restaurant>
        get() = _data
}
