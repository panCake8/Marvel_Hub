package com.example.marvel_hub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("EventsEntity")
data class EventsEntity(
    @PrimaryKey var id: Int,
    var name: String,
    var description: String,
    var modified: String,
    var imagUrl: String
)
