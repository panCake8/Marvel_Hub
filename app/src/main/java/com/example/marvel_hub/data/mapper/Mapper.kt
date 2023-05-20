package com.example.marvel_hub.data.mapper

interface Mapper<I, O> {

    fun map(input: I): O
}