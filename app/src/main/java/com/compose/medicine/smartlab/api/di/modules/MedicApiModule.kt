package com.compose.medicine.smartlab.api.di.modules

import com.compose.medicine.smartlab.api.data.MedicRepository
import com.compose.medicine.smartlab.api.data.remote.MedicApiDataSource
import com.compose.medicine.smartlab.api.data.remote.MedicRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
interface MedicApiModule {

    companion object {
        @Provides
        fun provideApiDataSource(
            retrofit: Retrofit
        ): MedicApiDataSource = retrofit.create(MedicApiDataSource::class.java)
    }

    @Binds
    fun bindMedicRepository(impl: MedicRepositoryImpl): MedicRepository
}