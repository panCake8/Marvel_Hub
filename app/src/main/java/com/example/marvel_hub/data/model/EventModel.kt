package com.example.marvel_hub.data.model

import com.example.marvel_hub.data.model.base.IResponseItem
import com.example.marvel_hub.data.model.base.Thumbnail
import com.google.gson.annotations.SerializedName

data class EventModel(

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("id")
    override val id: Int? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("thumbnail")
    override val thumbnail: Thumbnail?  = Thumbnail(),

    @field:SerializedName("start")
    val start: String? = null,

    @field:SerializedName("end")
    val end: String? = null,

    @field:SerializedName("modified")
    override val modified: String? = null,

    ) : IResponseItem
