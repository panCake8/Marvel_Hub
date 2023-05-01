package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.API

class MarvelRepository {
    fun getCharacters() = API.apiService.getAllCharacters()
}