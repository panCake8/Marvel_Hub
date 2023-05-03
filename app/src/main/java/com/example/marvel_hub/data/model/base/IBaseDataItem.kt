package com.example.marvel_hub.data.model.base

import com.example.marvel_hub.data.model.Thumbnail

interface IBaseDataItem {

    val id: Int?

    val description: String?

    val thumbnail: Thumbnail?

    val rating: String?

    val modified: String?
}