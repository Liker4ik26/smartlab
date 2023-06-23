package com.compose.medicine.smartlab.navigation.models.mappers

import com.compose.medicine.smartlab.screens.analysis_details.presentation.AnalysisDetails
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisDetailsNavArg

fun AnalysisDetailsNavArg.asDetails(): AnalysisDetails {
    return AnalysisDetails(
        id = id,
        cardId = cardId,
        title = name,
        description = description,
        preparation = preparation,
        category = category,
        timeResult = timeResult,
        biomaterial = bio,
        price = price
    )
}