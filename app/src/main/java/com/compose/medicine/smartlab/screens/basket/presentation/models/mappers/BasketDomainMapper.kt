package com.compose.medicine.smartlab.screens.basket.presentation.models.mappers

import com.compose.medicine.smartlab.database.domain.models.BasketDomain
import com.compose.medicine.smartlab.screens.basket.presentation.models.BasketItemUi

fun BasketItemUi.asBasketItem(): BasketDomain {
    return BasketDomain(
        id = id,
        cardId = cardId,
        timeResult = timeResult,
        name = name,
        price = price,
        description = description,
        preparation = preparation,
        biomaterial = biomaterial,
        category = category,
        countPatient = countPatient
    )
}