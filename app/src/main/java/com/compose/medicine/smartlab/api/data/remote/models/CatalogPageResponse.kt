package com.compose.medicine.smartlab.api.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CatalogPageResponse(
    @Json(name = "results")
    val results: List<CatalogResponse>
)

@JsonClass(generateAdapter = true)
class CatalogResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "category")
    val category: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "price")
    val price: String,
    @Json(name = "time_result")
    val timeResult: String,
    @Json(name = "bio")
    val bio: String,
    @Json(name = "preparation")
    val preparation: String,
    @Json(name = "description")
    val description: String
)

@JsonClass(generateAdapter = true)
class AnalysisSourceResponse(
    @Json(name = "Analysis")
    val analysis: String
)