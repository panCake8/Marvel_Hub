package com.example.marvel_hub.data.model.base

import com.google.gson.annotations.SerializedName

data class BaseModel<T>(
    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: BaseModelData<T>? = null,
)

data class BaseModelData<T>(

    @field:SerializedName("results")
    val results: List<T?>? = null
)

data class Thumbnail(

    @field:SerializedName("path")
    val path: String? = null,

    @field:SerializedName("extension")
    val extension: String? = null
)