package com.compose.medicine.smartlab.database.domain.models.mappers

import com.compose.medicine.smartlab.database.data.local.models.BasketEntity
import com.compose.medicine.smartlab.database.domain.models.BasketDomain

fun BasketDomain.asBasketEntity(): BasketEntity {
    return BasketEntity(
        cardId = cardId,
        timeResult = timeResult,
        name = name,
        price = price,
        description = description,
        preparation = preparation,
        biomaterial = biomaterial,
        category = category
    )
}