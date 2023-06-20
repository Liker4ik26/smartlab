package com.compose.medicine.smartlab.screens.analysis_details.presentation.models

class AnalysisDetailsItemUi(
    val id: Int = 0,
    val cardId: Int,
    val timeResult: String,
    val title: String?,
    val description: String?,
    val preparation: String?,
    val biomaterial: String,
    val category: Int,
    val price: String,
    val countPatient: Int
)