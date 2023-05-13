package com.example.marvel_hub.data.model


data class CharactersModel(
    val description: String? = "",
    val id: Int? = 0,
    val modified: String? = "",
    val name: String? = "",
    val thumbnail: Thumbnail? = Thumbnail(),
    val comics: InfoModel? = InfoModel(),
    val events: InfoModel? = InfoModel(),
    val series: InfoModel? = InfoModel(),
    val stories: InfoModel? = InfoModel(),
)