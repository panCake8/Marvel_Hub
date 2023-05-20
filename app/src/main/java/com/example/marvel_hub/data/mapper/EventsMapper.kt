package com.example.marvel_hub.data.mapper

import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.local.entities.EventEntity
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel

class EventsMapper:Mapper<EventModel,EventEntity> {
    override fun map(input: EventModel): EventEntity {
        return EventEntity(
            id = input.id ?: 0,
            title = input.title ?: "",
            description = input.description ?: "",
            modified = input.modified ?: "",
            imageUrl = input.thumbnail?.getImage() ?: ""
        )
    }
}