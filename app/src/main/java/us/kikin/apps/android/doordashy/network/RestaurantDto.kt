package us.kikin.apps.android.doordashy.network

import com.google.gson.annotations.SerializedName

data class RestaurantDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("cover_img_url") val imageUrl: String,
    @SerializedName("status") val status: String,
    @SerializedName("delivery_fee") val deliveryFee: Int
)
