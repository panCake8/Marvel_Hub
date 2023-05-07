package com.example.marvel_hub.data.model

data class Thumbnail(
    val path: String? = null,
    val extension: String? = null,
) {
    fun getImage() = "$path.$extension"
}