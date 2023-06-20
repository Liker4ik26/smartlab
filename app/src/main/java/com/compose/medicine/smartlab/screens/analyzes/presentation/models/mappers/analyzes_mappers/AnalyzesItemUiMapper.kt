package com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.analyzes_mappers

import com.compose.medicine.smartlab.api.domain.CatalogDomain
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisItemUi

fun CatalogDomain.asAnalyzesItemUi(): AnalysisItemUi {
    return AnalysisItemUi(
        id = cardId,
        cardId = cardId,
        category = category,
        name = name,
        price = price,
        timeResult = timeResult,
        bio = bio,
        description = description,
        preparation = preparation,
    )
}