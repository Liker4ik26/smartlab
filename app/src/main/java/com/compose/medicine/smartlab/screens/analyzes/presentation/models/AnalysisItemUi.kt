package com.compose.medicine.smartlab.screens.analyzes.presentation.models

class AnalysisItemUi(
    val id: Int,
    val cardId: Int,
    val category: Int,
    val name: String?,
    val price: String,
    val timeResult: String,
    val bio: String,
    val description: String?,
    val preparation: String?,
    val patientCount: Int = 1,
    val isSelected: Boolean = false
)

fun AnalysisItemUi.asNavArg(): AnalysisDetailsNavArg {
    return AnalysisDetailsNavArg(
        id = id,
        cardId = cardId,
        name = name,
        price = price,
        timeResult = timeResult,
        bio = bio,
        description = description,
        preparation = preparation,
        category = category
    )
}