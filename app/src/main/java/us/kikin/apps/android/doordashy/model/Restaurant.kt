package us.kikin.apps.android.doordashy.model

import us.kikin.apps.android.doordashy.network.RestaurantDto

data class Restaurant(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val status: String,
    val deliveryFee: Int
) {
    constructor(dto: RestaurantDto) : this(
        dto.id,
        dto.name,
        dto.description,
        dto.imageUrl,
        dto.status,
        dto.deliveryFee
    )
}
