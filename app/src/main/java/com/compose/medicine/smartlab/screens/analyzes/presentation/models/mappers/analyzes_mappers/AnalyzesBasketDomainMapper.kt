package com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.analyzes_mappers

import com.compose.medicine.smartlab.database.domain.models.BasketDomain
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisItemUi

fun AnalysisItemUi.asBasketDomain(): BasketDomain {
    return BasketDomain(
        id = id,
        cardId = cardId,
        timeResult = timeResult,
        name = name,
        description = description,
        preparation = preparation,
        biomaterial = bio,
        category = category,
        price = price,
        countPatient = patientCount
    )
}