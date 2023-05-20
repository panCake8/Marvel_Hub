package com.example.marvel_hub.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}