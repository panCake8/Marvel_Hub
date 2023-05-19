package com.example.marvel_hub.domain.mapper

import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.domain.models.SearchResult

class SearchResultEventsMapper  : Mapper<EventModel, SearchResult> {
    override fun map(input: EventModel): SearchResult {
        return input.let {
            SearchResult(
                id = input.id,
                name = it.title,
                imageUrl = it.thumbnail?.getImage()


            )
        }
    }
}