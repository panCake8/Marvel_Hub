package com.example.marvel_hub.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchKeywordEntity(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo val searchKeyword: String
)