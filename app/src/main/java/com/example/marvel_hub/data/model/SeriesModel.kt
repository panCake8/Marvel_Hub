package com.example.marvel_hub.data.model

import com.google.gson.annotations.SerializedName

data class SeriesModel(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: SeriesData? = null,
)

data class SeriesData(

    @field:SerializedName("results")
    val results: List<SeriesItem?>? = null
)

data class SeriesItem(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,

    @field:SerializedName("rating")
    val rating: String? = null,
)
