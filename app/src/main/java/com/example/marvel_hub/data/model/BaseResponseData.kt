package com.example.marvel_hub.data.model

data class BaseResponseData<T>(
    val results: List<T>? = listOf(),
    val total: Int? = null,
)