package com.example.marvel_hub.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventModel(
    val title: String? = null,
    @PrimaryKey(autoGenerate = false) val id: Int? = null,
    val description: String? = null,
    val thumbnail: Thumbnail? = Thumbnail(),
    val start: String? = null,
    val end: String? = null,
    val modified: String? = null,
)
