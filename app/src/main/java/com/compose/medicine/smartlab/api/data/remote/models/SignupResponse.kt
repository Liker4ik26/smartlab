package com.compose.medicine.smartlab.api.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SignupResponse(
    @Json(name = "refresh")
    val refresh: String,
    @Json(name = "access")
    val access: String
)