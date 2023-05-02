package com.example.marvel_hub.data.model

import com.google.gson.annotations.SerializedName

data class StoriesModel(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: Data? = null,
)

data class Data(

    @field:SerializedName("results")
    val results: List<StoriesItem?>? = null
)

data class StoriesItem(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,

    @field:SerializedName("type")
    val type: String? = null,
)