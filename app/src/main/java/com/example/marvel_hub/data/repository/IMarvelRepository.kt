package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.model.CharactersModel
import io.reactivex.rxjava3.core.Single

interface IMarvelRepository {
    fun getAllCharacters(): Single<CharactersModel>

    fun getCharacterById(characterId: Int): Single<CharactersModel>
}