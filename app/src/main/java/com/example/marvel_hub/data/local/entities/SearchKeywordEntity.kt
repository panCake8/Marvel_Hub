package com.example.marvel_hub.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchKeywordEntity(
    @PrimaryKey val id : Int,
    @ColumnInfo val searchKeyword: String,
    @ColumnInfo val type : String,
)