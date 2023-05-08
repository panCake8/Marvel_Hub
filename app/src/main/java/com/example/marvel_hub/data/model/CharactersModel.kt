package com.example.marvel_hub.data.model


data class CharactersModel(
    val description: String? = "",
    val id: Int? = 0,
    val modified: String? = "",
    val name: String? = "",
    val thumbnail: Thumbnail? = Thumbnail(),
    val comics: Info? = Info(),
    val events: Info? = Info(),
    val series: Info? = Info(),
    val stories: Info? = Info(),
)