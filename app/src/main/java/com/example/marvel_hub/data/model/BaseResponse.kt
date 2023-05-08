package com.example.marvel_hub.data.model


data class BaseResponse<T>(
    val code: Int? = null,
    val status: String? = null,
    val data: BaseResponseData<T>? = null,
)