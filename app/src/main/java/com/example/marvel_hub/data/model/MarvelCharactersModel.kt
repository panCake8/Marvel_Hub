package com.example.marvel_hub.data.model


import com.google.gson.annotations.SerializedName

data class MarvelCharactersModel(
    val attributionHTML: String? = "",
    val attributionText: String? = "",
    val code: Int? = 0,
    val copyright: String? = "",
    val `data`: Data? = Data(),
    @SerializedName("etag") val tag: String? = "",
    val status: String? = ""
) {
    data class Data(
        val count: Int? = 0,
        val limit: Int? = 0,
        val offset: Int? = 0,
        val results: List<Result?>? = listOf(),
        val total: Int? = 0
    ) {
        data class Result(
            val comics: Comics? = Comics(),
            val description: String? = "",
            val events: Events? = Events(),
            val id: Int? = 0,
            val modified: String? = "",
            val name: String? = "",
            val resourceURI: String? = "",
            val series: Series? = Series(),
            val stories: Stories? = Stories(),
            val thumbnail: Thumbnail? = Thumbnail(),
            val urls: List<Url?>? = listOf()
        ) {
            data class Comics(
                val available: Int? = 0,
                val collectionURI: String? = "",
                val items: List<Item?>? = listOf(),
                val returned: Int? = 0
            ) {
                data class Item(
                    val name: String? = "",
                    val resourceURI: String? = ""
                )
            }

            data class Events(
                val available: Int? = 0,
                val collectionURI: String? = "",
                val items: List<Item?>? = listOf(),
                val returned: Int? = 0
            ) {
                data class Item(
                    val name: String? = "",
                    val resourceURI: String? = ""
                )
            }

            data class Series(
                val available: Int? = 0,
                val collectionURI: String? = "",
                val items: List<Item?>? = listOf(),
                val returned: Int? = 0
            ) {
                data class Item(
                    val name: String? = "",
                    val resourceURI: String? = ""
                )
            }

            data class Stories(
                val available: Int? = 0,
                val collectionURI: String? = "",
                val items: List<Item?>? = listOf(),
                val returned: Int? = 0
            ) {
                data class Item(
                    val name: String? = "",
                    val resourceURI: String? = "",
                    val type: String? = ""
                )
            }

            data class Thumbnail(
                val extension: String? = "",
                val path: String? = ""
            )

            data class Url(
                val type: String? = "",
                val url: String? = ""
            )
        }
    }
}