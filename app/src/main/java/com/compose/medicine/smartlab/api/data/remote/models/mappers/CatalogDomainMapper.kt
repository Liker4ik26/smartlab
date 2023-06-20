package com.compose.medicine.smartlab.api.data.remote.models.mappers

import com.compose.medicine.smartlab.api.data.remote.models.CatalogResponse
import com.compose.medicine.smartlab.api.domain.CatalogDomain

fun CatalogResponse.toCatalogDomain(): CatalogDomain {
    return CatalogDomain(
        cardId = id,
        category = category,
        name = name,
        price = price,
        timeResult = timeResult,
        bio = bio,
        description = description,
        preparation = preparation
    )
}