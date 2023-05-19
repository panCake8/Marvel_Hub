package com.example.marvel_hub.domain.mapper

import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.domain.models.SearchResult

class SearchResultSeriesMapper : Mapper<SeriesModel, SearchResult> {
    override fun map(input: SeriesModel): SearchResult {
        return input.let {
            SearchResult(
                id = input.id,
                name = it.title,
                imageUrl = it.thumbnail?.getImage()


            )
        }
    }
}