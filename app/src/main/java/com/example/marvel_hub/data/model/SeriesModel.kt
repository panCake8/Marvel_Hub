package com.example.marvel_hub.data.model

import com.example.marvel_hub.data.model.base.IResponseItem
import com.example.marvel_hub.data.model.base.Thumbnail
import com.google.gson.annotations.SerializedName

data class SeriesModel(

    @field:SerializedName("id")
    override val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("thumbnail")
    override val thumbnail: Thumbnail?  = Thumbnail(),

    @field:SerializedName("rating")
    val rating: String? = null,

    @field:SerializedName("startYear")
    val startYear: String? = null,

    @field:SerializedName("endYear")
    val endYear: String? = null,

    @field:SerializedName("modified")
    override val modified: String? = null,
) : IResponseItem
