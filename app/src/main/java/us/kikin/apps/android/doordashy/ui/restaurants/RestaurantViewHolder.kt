package us.kikin.apps.android.doordashy.ui.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import us.kikin.apps.android.doordashy.R
import us.kikin.apps.android.doordashy.databinding.ItemRestaurantBinding
import us.kikin.apps.android.doordashy.model.Restaurant

class RestaurantViewHolder(
    private val binding: ItemRestaurantBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Restaurant, viewModel: RestaurantViewModel) {
        binding.restaurant = item
        binding.viewmodel = viewModel
        if (item.favorite) {
            binding.favorite.setImageResource(R.drawable.ic_favorite_24px)
        } else {
            binding.favorite.setImageResource(R.drawable.ic_favorite_border_24px)
        }
        binding.favorite.setOnClickListener {
            Toast.makeText(binding.favorite.context, "Favorite clicked", Toast.LENGTH_SHORT).show()
            viewModel.favoriteRestaurant(item.id, !item.favorite)
        }
    }

    companion object {
        fun from(parent: ViewGroup): RestaurantViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemRestaurantBinding.inflate(inflater, parent, false)
            return RestaurantViewHolder(binding)
        }
    }
}
