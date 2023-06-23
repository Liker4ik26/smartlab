package com.compose.medicine.smartlab.screens.analysis_details.presentation.models.mappers

import com.compose.medicine.smartlab.database.domain.models.BasketDomain
import com.compose.medicine.smartlab.screens.analysis_details.presentation.AnalysisDetails

fun AnalysisDetails.toBasketDomain(): BasketDomain {
    return BasketDomain(
        id = id,
        cardId = cardId,
        name = title,
        description = description,
        preparation = preparation,
        timeResult = timeResult,
        category = category,
        biomaterial = biomaterial,
        price = price,
        countPatient = 1
    )
}