package us.kikin.apps.android.doordashy.ui.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import us.kikin.apps.android.doordashy.databinding.ItemRestaurantBinding
import us.kikin.apps.android.doordashy.model.Restaurant

class RestaurantViewHolder(
    private val binding: ItemRestaurantBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Restaurant) {
        with(binding) { restaurant = item }
    }

    companion object {
        fun from(parent: ViewGroup): RestaurantViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemRestaurantBinding.inflate(inflater, parent, false)
            return RestaurantViewHolder(binding)
        }
    }
}
