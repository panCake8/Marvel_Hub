package com.example.marvel_hub.domain.mapper

import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.domain.models.SearchResult

class SearchResultComicMapper : Mapper<ComicModel, SearchResult> {
    override fun map(input: ComicModel): SearchResult {
        return input.let {
            SearchResult(
                id = input.id,
                name = it.name,
                imageUrl = it.thumbnail?.getImage()


            )
        }
    }
}