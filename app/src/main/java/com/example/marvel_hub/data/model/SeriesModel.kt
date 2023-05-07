package com.example.marvel_hub.data.model


data class SeriesModel(
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val thumbnail: Thumbnail? = Thumbnail(),
    val rating: String? = null,
    val startYear: String? = null,
    val endYear: String? = null,
    val modified: String? = null,
)
