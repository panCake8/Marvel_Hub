package com.example.marvel_hub.data.model

import com.example.marvel_hub.data.model.base.IDataItem
import com.google.gson.annotations.SerializedName

data class SeriesItem(

    @field:SerializedName("id")
    override val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("description")
    override val description: String? = null,

    @field:SerializedName("thumbnail")
    override val thumbnail: Thumbnail? = null,

    @field:SerializedName("rating")
    val rating: String? = null,

    @field:SerializedName("startYear")
    val startYear: String? = null,

    @field:SerializedName("endYear")
    val endYear: String? = null,

    @field:SerializedName("modified")
    override val modified: String? = null,
) : IDataItem
