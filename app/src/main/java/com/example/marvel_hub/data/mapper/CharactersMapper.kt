package com.example.marvel_hub.data.mapper

import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel

class CharactersMapper:Mapper<CharactersModel,CharacterEntity> {
    override fun map(input: CharactersModel): CharacterEntity {
        return CharacterEntity(
            id = input.id ?: 0,
            name = input.name ?: "",
            description = input.description ?: "",
            modified = input.modified ?: "",
            imageUrl = input.thumbnail?.getImage() ?: ""
        )
    }
}