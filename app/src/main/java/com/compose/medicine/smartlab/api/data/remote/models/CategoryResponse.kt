package com.compose.medicine.smartlab.api.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CategoryPageResponse(
    @Json(name = "results")
    val results: List<CategoryResponse>
)

@JsonClass(generateAdapter = true)
class CategoryResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
class CategorySourceResponse(
    @Json(name = "Category")
    val category: String
)