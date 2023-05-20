package com.example.marvel_hub.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SeriesModel(
    @PrimaryKey(autoGenerate = false) val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val thumbnail: Thumbnail? = null,
    val rating: String? = null,
    val startYear: String? = null,
    val endYear: String? = null,
    val modified: String? = null,
)
