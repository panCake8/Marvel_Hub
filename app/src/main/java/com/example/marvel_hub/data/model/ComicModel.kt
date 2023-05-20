package com.example.marvel_hub.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ComicModel(
    val description: String? = null,
    val title: String? = null,
    val modified: String? = null,
   @PrimaryKey(autoGenerate = false) val id: Int? = null,
    val thumbnail: Thumbnail? = Thumbnail(),
    val name: String? = null,
    val pageCount: Int,
    val prices: List<PricesItemModel?>? = null,
)