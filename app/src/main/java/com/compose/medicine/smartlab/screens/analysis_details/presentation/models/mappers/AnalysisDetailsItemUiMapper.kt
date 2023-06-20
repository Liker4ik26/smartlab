package com.compose.medicine.smartlab.screens.analysis_details.presentation.models.mappers

import com.compose.medicine.smartlab.database.domain.models.BasketDomain
import com.compose.medicine.smartlab.screens.analysis_details.presentation.models.AnalysisDetailsItemUi

fun BasketDomain.asAnalysisUi(): AnalysisDetailsItemUi {
    return AnalysisDetailsItemUi(
        id = id,
        cardId = cardId,
        title = name,
        description = description,
        preparation = preparation,
        category = category,
        timeResult = timeResult,
        biomaterial = biomaterial,
        price = price,
        countPatient = countPatient
    )
}