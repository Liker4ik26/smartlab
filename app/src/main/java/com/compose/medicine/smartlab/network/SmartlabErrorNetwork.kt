package com.compose.medicine.smartlab.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SmartlabErrorNetwork(
    @Json(name = "details")
    val details: String
)