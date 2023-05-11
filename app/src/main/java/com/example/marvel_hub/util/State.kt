package com.example.marvel_hub.util

sealed class State<out T> {
    data class Success<T>(val data: T) : State<T>()

    data class SuccessList<T>(val data: List<T>) : State<T>()
    data class Error(val message: String) : State<Nothing>()
    object Loading : State<Nothing>()

    fun toData(): T? = if (this is Success) data else null
    fun toDataList(): List<T>? = if (this is SuccessList) data else null
}