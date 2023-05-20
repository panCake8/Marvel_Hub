package com.example.marvel_hub.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharactersModel(
    val description: String? = "",
    @PrimaryKey(autoGenerate = false) val id: Int? = 0,
    val modified: String? = "",
    val name: String? = "",
    val thumbnail: Thumbnail? = null,
    val comics: InfoModel? = null,
    val events: InfoModel? = null,
    val series: InfoModel? = null,
    val stories: InfoModel? = null,
)