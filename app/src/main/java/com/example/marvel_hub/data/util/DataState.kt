package com.example.marvel_hub.data.util

sealed class DataState<out T> {
    data class Success<T>(val data: List<T>) : DataState<T>()
    data class Error(val message: String) : DataState<Nothing>()
    object Loading : DataState<Nothing>()

    fun toData(): List<T>? = if (this is Success) data else null
}