package com.example.marvel_hub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchResultEntity(
    @PrimaryKey var id:Long,
    var name:String,
    var imageUrl:String
)
