package com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.analyzes_mappers

import com.compose.medicine.smartlab.database.domain.models.BasketDomain
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisItemUi

fun BasketDomain.asAnalItemUi(): AnalysisItemUi {
    return AnalysisItemUi(
        id = cardId,
        cardId = cardId,
        category = category,
        name = name,
        price = price,
        timeResult = timeResult,
        bio = biomaterial,
        description = description,
        preparation = preparation,
    )
}