package com.example.marvel_hub.util


import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ouattararomuald.slider.ImageLoader


class GlideImageLoader(
    private val requestOptions: RequestOptions?,
    eventListener: EventListener? = null
) : ImageLoader(eventListener) {

    override fun load(path: String, imageView: ImageView) {
        if (requestOptions != null) {
            Glide.with(imageView).load(path).apply(requestOptions).into(imageView)
        } else {
            Glide.with(imageView).load(path).apply {
                into(imageView)
            }
        }
    }
}