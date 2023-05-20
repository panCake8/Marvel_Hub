package com.example.marvel_hub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BannerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val image: String,
)
