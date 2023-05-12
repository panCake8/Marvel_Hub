package com.example.marvel_hub.data.model

data class InfoModel(
    val available: Int? = 0,
    val collectionURI: String? = "",
    val infoItemModels: List<InfoItemModel?>? = listOf(),
    val returned: Int? = 0
)
