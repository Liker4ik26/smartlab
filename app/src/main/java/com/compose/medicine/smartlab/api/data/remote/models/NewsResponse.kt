package com.compose.medicine.smartlab.api.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NewsPageResponse(
    @Json(name = "results")
    val results: List<NewsResponse>
)

@JsonClass(generateAdapter = true)
class NewsResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "price")
    val price: String,
    @Json(name = "image")
    val image: String,
)

@JsonClass(generateAdapter = true)
class NewsSourceResponse(
    @Json(name = "New")
    val news: String
)