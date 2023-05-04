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

    @field:SerializedName("id")
    override val id: Int? = null,

    @field:SerializedName("description")
    override val description: String? = null,

    @field:SerializedName("thumbnail")
    override val thumbnail: Thumbnail? = null,

    @field:SerializedName("rating")
    override val rating: String? = null,

    @field:SerializedName("modified")
    override val modified: String? = null,

    ) : IBaseDataItem

data class Thumbnail(

    @field:SerializedName("path")
    val path: String? = null,

    @field:SerializedName("extension")
    val extension: String? = null
)
