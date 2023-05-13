package com.example.marvel_hub.util

import com.bumptech.glide.request.RequestOptions
import com.ouattararomuald.slider.ImageLoader

class GlideImageLoaderFactory(
    private val eventListener: ImageLoader.EventListener? = null,
    private val requestOptions: RequestOptions? = null
) : ImageLoader.Factory<GlideImageLoader> {

    override fun create(): GlideImageLoader = GlideImageLoader(requestOptions, eventListener)
}