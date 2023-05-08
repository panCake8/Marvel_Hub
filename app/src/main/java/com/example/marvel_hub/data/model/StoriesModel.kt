package com.example.marvel_hub.data.model


data class StoriesModel(
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val thumbnail: Thumbnail? = Thumbnail(),
    val type: String? = null,
    val modified: String? = null,
)