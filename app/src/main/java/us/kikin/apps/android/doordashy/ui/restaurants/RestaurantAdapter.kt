package us.kikin.apps.android.doordashy.ui.restaurants

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import us.kikin.apps.android.doordashy.model.Restaurant

class RestaurantAdapter(
    private val viewModel: RestaurantViewModel
) : ListAdapter<Restaurant, RestaurantViewHolder>(RestaurantDiffCallback()) {

    private val items = ArrayList<Restaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder =
        RestaurantViewHolder.from(parent)

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, viewModel)
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<Restaurant>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class RestaurantDiffCallback : DiffUtil.ItemCallback<Restaurant>() {
    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem == newItem
    }
}
