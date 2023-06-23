package com.compose.medicine.smartlab.api.data.remote

import com.compose.medicine.smartlab.api.data.remote.models.CatalogPageResponse
import com.compose.medicine.smartlab.api.data.remote.models.CategoryPageResponse
import com.compose.medicine.smartlab.api.data.remote.models.NewsPageResponse
import com.compose.medicine.smartlab.api.data.remote.models.UserModel
import com.compose.medicine.smartlab.core.ErrorReason
import com.compose.medicine.smartlab.core.entity.Either
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MedicApiDataSource {
    companion object {
        const val DEFAULT_PAGE_SIZE = 16
        const val START_PAGE = 1
    }

    @GET("api/catalog")
    suspend fun getCatalogAnalysis(): Either<ErrorReason, CatalogPageResponse>

    @GET("api/news/")
    suspend fun getNews(): Either<ErrorReason, NewsPageResponse>

    @GET("api/category")
    suspend fun getCategory(): Either<ErrorReason, CategoryPageResponse>

    @POST("api/signup/")
    suspend fun createUser(@Body user: UserModel)
}