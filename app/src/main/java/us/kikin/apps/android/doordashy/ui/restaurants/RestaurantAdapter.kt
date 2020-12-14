package us.kikin.apps.android.doordashy.ui.restaurants

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import us.kikin.apps.android.doordashy.model.Restaurant

class RestaurantAdapter : RecyclerView.Adapter<RestaurantViewHolder>() {

    private val items = ArrayList<Restaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder =
        RestaurantViewHolder.from(parent)

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<Restaurant>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
