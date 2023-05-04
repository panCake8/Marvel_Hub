package com.example.marvel_hub.data.model

import com.example.marvel_hub.data.model.base.IDataItem
import com.example.marvel_hub.data.model.base.Thumbnail
import com.google.gson.annotations.SerializedName

data class ComicModel(

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("modified")
    override val modified: String? = null,

    @field:SerializedName("id")
    override val id: Int? = null,

    override val thumbnail: Thumbnail?,

    ) : IDataItem