package com.example.marvel_hub.data.model

data class BaseResponseData<T>(
    val results: List<T>? = null,
    val total: Int? = null,
)