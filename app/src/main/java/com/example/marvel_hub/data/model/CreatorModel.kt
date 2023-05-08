package com.example.marvel_hub.data.model


data class CreatorModel(
    val lastName: String? = null,
    val thumbnail: Thumbnail? = Thumbnail(),
    val fullName: String? = null,
    val suffix: String? = null,
    val firstName: String? = null,
    val modified: String? = null,
    val middleName: String? = null,
    val id: Int? = null,
)