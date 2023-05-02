package com.example.marvel_hub.data.model

import com.google.gson.annotations.SerializedName

data class EventModel(

    @field:SerializedName("copyright")
    val copyright: String? = null,

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: EventData? = null,

    @field:SerializedName("attributionHTML")
    val attributionHTML: String? = null,

    @field:SerializedName("attributionText")
    val attributionText: String? = null,

    @field:SerializedName("etag")
    val etag: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)

data class EventData(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("offset")
    val offset: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("results")
    val results: List<EventResultsItem?>? = null
)

data class EventResultsItem(

    @field:SerializedName("next")
    val next: Next? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,

    @field:SerializedName("stories")
    val stories: Stories? = null,

    @field:SerializedName("previous")
    val previous: Previous? = null,

    @field:SerializedName("creators")
    val creators: Creators? = null,

    @field:SerializedName("comics")
    val comics: Comics? = null,

    @field:SerializedName("start")
    val start: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("resourceURI")
    val resourceURI: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("characters")
    val characters: Characters? = null,

    @field:SerializedName("urls")
    val urls: List<UrlsItem?>? = null,

    @field:SerializedName("series")
    val series: Series? = null,

    @field:SerializedName("modified")
    val modified: String? = null,

    @field:SerializedName("end")
    val end: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

data class Next(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("resourceURI")
    val resourceURI: String? = null
)

data class Previous(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("resourceURI")
    val resourceURI: String? = null
)

data class Thumbnail(

    @field:SerializedName("path")
    val path: String? = null,

    @field:SerializedName("extension")
    val extension: String? = null
)

data class UrlsItem(

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class Characters(

    @field:SerializedName("collectionURI")
    val collectionURI: String? = null,

    @field:SerializedName("available")
    val available: Int? = null,

    @field:SerializedName("returned")
    val returned: Int? = null,

    @field:SerializedName("items")
    val items: List<Item?>? = null
)

data class Stories(

    @field:SerializedName("collectionURI")
    val collectionURI: String? = null,

    @field:SerializedName("available")
    val available: Int? = null,

    @field:SerializedName("returned")
    val returned: Int? = null,

    @field:SerializedName("items")
    val items: List<Item?>? = null
)

data class Series(

    @field:SerializedName("collectionURI")
    val collectionURI: String? = null,

    @field:SerializedName("available")
    val available: Int? = null,

    @field:SerializedName("returned")
    val returned: Int? = null,

    @field:SerializedName("items")
    val items: List<Item?>? = null
)

data class Comics(

    @field:SerializedName("collectionURI")
    val collectionURI: String? = null,

    @field:SerializedName("available")
    val available: Int? = null,

    @field:SerializedName("returned")
    val returned: Int? = null,

    @field:SerializedName("items")
    val items: List<Item?>? = null
)

data class Creators(

    @field:SerializedName("collectionURI")
    val collectionURI: String? = null,

    @field:SerializedName("available")
    val available: Int? = null,

    @field:SerializedName("returned")
    val returned: Int? = null,

    @field:SerializedName("items")
    val items: List<Item?>? = null
)

data class Item(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("resourceURI")
    val resourceURI: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("role")
    val role: String? = null
)
