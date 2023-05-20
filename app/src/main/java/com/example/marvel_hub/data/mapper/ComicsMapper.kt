package com.example.marvel_hub.data.mapper

import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.model.ComicModel

class ComicsMapper:Mapper<ComicModel,ComicEntity> {
    override fun map(input: ComicModel): ComicEntity {
        return ComicEntity(
            id = input.id ?: 0,
            title = input.title ?: "",
            description = input.description ?: "",
            modified = input.modified ?: "",
            imageUrl = input.thumbnail?.getImage() ?: ""
        )
    }
}