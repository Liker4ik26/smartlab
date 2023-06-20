package com.compose.medicine.smartlab.api.data.remote.models.mappers

import com.compose.medicine.smartlab.api.data.remote.models.CategoryResponse
import com.compose.medicine.smartlab.api.domain.CategoryDomain

fun CategoryResponse.asCategoryDomain(): CategoryDomain {
    return CategoryDomain(
        id = id,
        name = name
    )
}