package com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.news_mappers

import com.compose.medicine.smartlab.api.domain.NewsDomain
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.NewsAndStockItemUi

fun NewsDomain.asNewsItemUi(): NewsAndStockItemUi {
    return NewsAndStockItemUi(
        id = id,
        name = name,
        description = description,
        price = price,
        image = image
    )
}