package com.example.marvel_hub.data.model

import com.example.marvel_hub.data.model.base.IDataItem
import com.example.marvel_hub.data.model.base.Thumbnail
import com.google.gson.annotations.SerializedName

data class CreatorModel(

    @field:SerializedName("lastName")
    val lastName: String? = null,

    @field:SerializedName("thumbnail")
    override val thumbnail: Thumbnail? = null,

    @field:SerializedName("fullName")
    val fullName: String? = null,

    @field:SerializedName("suffix")
    val suffix: String? = null,

    @field:SerializedName("firstName")
    val firstName: String? = null,

    @field:SerializedName("modified")
    override val modified: String? = null,

    @field:SerializedName("middleName")
    val middleName: String? = null,

    @field:SerializedName("id")
    override val id: Int? = null,
) : IDataItem