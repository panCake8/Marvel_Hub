package com.example.marvel_hub.data.model


data class EventModel(
    val title: String? = null,
    val id: Int? = null,
    val description: String? = null,
    val thumbnail: Thumbnail? = Thumbnail(),
    val start: String? = null,
    val end: String? = null,
    val modified: String? = null,
)
