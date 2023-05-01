package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.api.API

class MarvelRepository : IMarvelRepository {
    override fun getAllCharacters() = API.apiService.getAllCharacters()

    override fun getCharacterById(characterId: Int) =
        API.apiService.getCharacterById(characterId = characterId)
}