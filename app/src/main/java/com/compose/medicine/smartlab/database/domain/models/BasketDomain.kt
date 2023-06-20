package com.compose.medicine.smartlab.database.domain.models

class BasketDomain(
    val id: Int,
    val cardId: Int,
    val timeResult: String,
    val name: String?,
    val description: String?,
    val preparation: String?,
    val biomaterial: String,
    val category: Int,
    val price: String,
    val countPatient: Int
)
