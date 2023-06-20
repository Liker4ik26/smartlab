package com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.category_mappers

import com.compose.medicine.smartlab.api.domain.CategoryDomain
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.CategoryItemUi

fun CategoryDomain.asCategoryItemUi(): CategoryItemUi {
    return CategoryItemUi(
        id = id,
        name = name
    )
}