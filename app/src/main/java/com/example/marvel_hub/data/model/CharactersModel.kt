package com.example.marvel_hub.data.model

import com.example.marvel_hub.data.model.base.IResponseItem
import com.example.marvel_hub.data.model.base.Thumbnail
import com.google.gson.annotations.SerializedName


data class CharactersModel(

    @field:SerializedName("description")
    val description: String? = "",

    @field:SerializedName("id")
    override val id: Int? = 0,

    @field:SerializedName("modified")
    override val modified: String? = "",

    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("thumbnail")
    override val thumbnail: Thumbnail? = Thumbnail()

) : IResponseItem