package us.kikin.apps.android.doordashy.ui.restaurants

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import us.kikin.apps.android.doordashy.Event
import us.kikin.apps.android.doordashy.data.source.RestaurantRepository
import us.kikin.apps.android.doordashy.model.Restaurant

class RestaurantViewModel @ViewModelInject constructor(
    private val repository: RestaurantRepository,
    @ApplicationContext private val application: Context,
) : ViewModel() {

    private val _data = MutableLiveData<List<Restaurant>>()
    val data: LiveData<List<Restaurant>>
        get() = _data

    private val _navigateToRestaurantEvent = MutableLiveData<Event<Long>>()
    val navigateToRestaurantEvent: LiveData<Event<Long>> = _navigateToRestaurantEvent

    init {
        getRestaurantsNearMe()
    }

    private fun getRestaurantsNearMe() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getNearestRestaurants(LAT, LONG)
                // iterate through list of restaurants and check if favorited
                // TODO: refactore this should be part of the repository class
                val sharedPref = PreferenceManager.getDefaultSharedPreferences(application)
                response.map {
                        it.favorite = sharedPref.getBoolean(it.id.toString(), false)
                }
                _data.postValue(response)
            } catch (e: Exception) {
                // TODO catch and show error ui
                Log.e("DASHY", e.toString())
            }
        }
    }

    /**
     * Called when the user taps on a restaurant
     */
    fun navigateToRestaurantDetail(restaurantId: Long) {
        _navigateToRestaurantEvent.value = Event(restaurantId)
    }

    fun favoriteRestaurant(restaurantId: Long, isFavorite: Boolean) {
        val copyOfList = _data.value
        copyOfList?.map {
            if (it.id == restaurantId) {
                it.favorite = isFavorite
            }
        }
        // save to cache
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(application)
        sharedPref.edit().putBoolean(restaurantId.toString(), isFavorite).commit()
        if (copyOfList != null) {
            _data.postValue(copyOfList!!)
        }
    }

    companion object {
        const val LAT = 37.422740
        const val LONG = -122.139956
    }
}
