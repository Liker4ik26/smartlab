package com.compose.medicine.smartlab.api.data

import com.compose.medicine.smartlab.api.domain.CatalogDomain
import com.compose.medicine.smartlab.api.domain.CategoryDomain
import com.compose.medicine.smartlab.api.domain.NewsDomain
import com.compose.medicine.smartlab.core.ErrorReason
import com.compose.medicine.smartlab.core.entity.Either

interface MedicRepository {
    suspend fun getAnalysisCatalogPagedFlow(): Either<ErrorReason, List<CatalogDomain>>
    suspend fun getNewsPageList(): Either<ErrorReason, List<NewsDomain>>
    suspend fun getCategoryList(): Either<ErrorReason, List<CategoryDomain>>
}