package us.kikin.apps.android.doordashy.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    view.load(url)
}
