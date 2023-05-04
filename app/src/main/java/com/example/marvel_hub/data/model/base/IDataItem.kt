package com.example.marvel_hub.data.model.base

import com.example.marvel_hub.data.model.Thumbnail

interface IDataItem {

    val id: Int?

    val description: String?

    val thumbnail: Thumbnail?

    val modified: String?
}