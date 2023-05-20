package com.example.marvel_hub.data.mapper

import com.example.marvel_hub.data.local.entities.SeriesEntity
import com.example.marvel_hub.data.model.SeriesModel

class SeriesMapper : Mapper<SeriesModel, SeriesEntity> {
    override fun map(input: SeriesModel): SeriesEntity {
        return SeriesEntity(
            id = input.id ?: 0,
            title = input.title ?: "",
            description = input.description ?: "",
            modified = input.modified ?: "",
            imageUrl = input.thumbnail?.getImage() ?: ""
        )
    }
}