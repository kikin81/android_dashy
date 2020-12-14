package us.kikin.apps.android.doordashy.ui.restaurants

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import us.kikin.apps.android.doordashy.model.Restaurant
import us.kikin.apps.android.doordashy.repository.RestaurantRepository

class RestaurantViewModel @ViewModelInject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _data = MutableLiveData<List<Restaurant>>()
    val data: LiveData<List<Restaurant>>
        get() = _data

    init {
        getRestaurantsNearMe()
    }

    private fun getRestaurantsNearMe() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getNearestRestaurants(LAT, LONG)
                _data.postValue(response)
            } catch (e: Exception) {
                // TODO catch and show error ui
                Log.e("DASHY", e.toString())
            }
        }
    }

    companion object {
        const val LAT = 37.422740
        const val LONG = -122.139956
    }
}
