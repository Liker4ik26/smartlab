package com.compose.medicine.smartlab.api.domain

class CatalogDomain(
    val cardId: Int,
    val category: Int,
    val name: String?,
    val price: String,
    val timeResult: String,
    val bio: String,
    val description: String?,
    val preparation: String?,
)