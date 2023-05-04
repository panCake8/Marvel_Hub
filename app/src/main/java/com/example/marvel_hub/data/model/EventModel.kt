package com.example.marvel_hub.data.model

import com.example.marvel_hub.data.model.base.IDataItem
import com.google.gson.annotations.SerializedName

data class EventItem(
    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("id")
    override val id: Int? = null,

    @field:SerializedName("description")
    override val description: String? = null,

    @field:SerializedName("thumbnail")
    override val thumbnail: Thumbnail? = null,

    @field:SerializedName("start")
    val start: String? = null,

    @field:SerializedName("end")
    val end: String? = null,

    @field:SerializedName("modified")
    override val modified: String? = null,

    ) : IDataItem

data class Thumbnail(

    @field:SerializedName("path")
    val path: String? = null,

    @field:SerializedName("extension")
    val extension: String? = null
)
