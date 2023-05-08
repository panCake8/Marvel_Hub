package com.example.marvel_hub.data.model

data class Info(
    val available: Int? = 0,
    val collectionURI: String? = "",
    val infoItems: List<InfoItem?>? = listOf(),
    val returned: Int? = 0
)
