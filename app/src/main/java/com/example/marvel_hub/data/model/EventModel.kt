package com.example.marvel_hub.data.model

import com.example.marvel_hub.data.model.base.IBaseDataItem
import com.google.gson.annotations.SerializedName

data class EventModel(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: EventData? = null,

    )

data class EventData(

    @field:SerializedName("results")
    val results: List<EventItem?>? = null
)

data class EventItem(

    @field:SerializedName("title")
    val title: String? = null,
)

data class Thumbnail(

    @field:SerializedName("path")
    val path: String? = null,

    @field:SerializedName("extension")
    val extension: String? = null
)
