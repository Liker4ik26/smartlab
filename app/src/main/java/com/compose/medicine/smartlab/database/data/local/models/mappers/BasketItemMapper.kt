package com.compose.medicine.smartlab.database.data.local.models.mappers

import com.compose.medicine.smartlab.database.data.local.models.BasketEntity
import com.compose.medicine.smartlab.database.domain.models.BasketDomain

fun BasketEntity.toBasketDomain(): BasketDomain {
    return BasketDomain(
        id = id,
        cardId = cardId,
        name = name,
        price = price,
        countPatient = countPatient,
        biomaterial = biomaterial,
        category = category,
        description = description,
        preparation = preparation,
        timeResult = timeResult
    )
}