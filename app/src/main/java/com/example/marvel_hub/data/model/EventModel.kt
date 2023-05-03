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

    @field:SerializedName("title")
    override val id: Int? = null,

    @field:SerializedName("title")
    override val description: String? = null,

    @field:SerializedName("title")
    override val thumbnail: Thumbnail? = null,

    @field:SerializedName("title")
    override val rating: String? = null,

    @field:SerializedName("title")
    override val modified: String? = null,

    ) : IBaseDataItem

data class Thumbnail(

    @field:SerializedName("path")
    val path: String? = null,

    @field:SerializedName("extension")
    val extension: String? = null
)
