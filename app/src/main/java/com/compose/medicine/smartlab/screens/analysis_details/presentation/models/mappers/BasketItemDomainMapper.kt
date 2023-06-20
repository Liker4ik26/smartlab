package com.compose.medicine.smartlab.screens.analysis_details.presentation.models.mappers

import com.compose.medicine.smartlab.database.domain.models.BasketDomain
import com.compose.medicine.smartlab.screens.analysis_details.presentation.models.AnalysisDetailsItemUi

fun AnalysisDetailsItemUi.asBasketItem(): BasketDomain {
    return BasketDomain(
        id = id,
        cardId = cardId,
        timeResult = timeResult,
        name = title,
        price = price,
        description = description,
        preparation = preparation,
        biomaterial = biomaterial,
        category = category,
        countPatient = countPatient
    )
}