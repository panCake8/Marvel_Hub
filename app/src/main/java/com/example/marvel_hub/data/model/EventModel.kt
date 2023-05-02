package com.example.marvel_hub.data.model

import com.google.gson.annotations.SerializedName

data class EventModel(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: EventData? = null,

)

data class EventData(

	@field:SerializedName("results")
	val results: List<EventItem?>? = null
)

data class EventItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: Thumbnail? = null,
)

data class Thumbnail(

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("extension")
	val extension: String? = null
)
