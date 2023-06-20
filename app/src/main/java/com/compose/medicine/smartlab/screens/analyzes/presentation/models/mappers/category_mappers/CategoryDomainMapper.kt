package com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.category_mappers

import com.compose.medicine.smartlab.api.domain.CategoryDomain
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.CategoryItemUi

fun CategoryItemUi.asCategoryDomain(): CategoryDomain {
    return CategoryDomain(
        id = id,
        name = name
    )
}