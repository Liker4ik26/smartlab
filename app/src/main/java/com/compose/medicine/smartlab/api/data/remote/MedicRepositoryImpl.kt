package com.compose.medicine.smartlab.api.data.remote

import android.content.Context
import com.compose.medicine.smartlab.api.data.MedicRepository
import com.compose.medicine.smartlab.api.data.remote.models.PatientModel
import com.compose.medicine.smartlab.api.data.remote.models.UserModel
import com.compose.medicine.smartlab.api.data.remote.models.mappers.asCategoryDomain
import com.compose.medicine.smartlab.api.data.remote.models.mappers.toCatalogDomain
import com.compose.medicine.smartlab.api.data.remote.models.mappers.toNewsDomain
import com.compose.medicine.smartlab.api.domain.CatalogDomain
import com.compose.medicine.smartlab.api.domain.CategoryDomain
import com.compose.medicine.smartlab.api.domain.NewsDomain
import com.compose.medicine.smartlab.core.ErrorReason
import com.compose.medicine.smartlab.core.entity.Either
import com.compose.medicine.smartlab.core.entity.map
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MedicRepositoryImpl @Inject constructor(
    @ApplicationContext context: Context,
    private val medicApiDataSource: MedicApiDataSource,
    private val moshi: Moshi
) : MedicRepository {
    override suspend fun getAnalysisCatalogPagedFlow(): Either<ErrorReason, List<CatalogDomain>> {
        return medicApiDataSource.getCatalogAnalysis()
            .map { it.results.map { it.toCatalogDomain() } }
    }

    override suspend fun getNewsPageList(): Either<ErrorReason, List<NewsDomain>> {
        return medicApiDataSource.getNews().map { it.results.map { it.toNewsDomain() } }
    }

    override suspend fun getCategoryList(): Either<ErrorReason, List<CategoryDomain>> {
        return medicApiDataSource.getCategory().map { it.results.map { it.asCategoryDomain() } }
    }

    override suspend fun createUser(
        user: UserModel
    ) {
        medicApiDataSource.createUser(user)
    }

    override suspend fun createPatient(patient: PatientModel) {
        medicApiDataSource.createPatient(patient)
    }
}