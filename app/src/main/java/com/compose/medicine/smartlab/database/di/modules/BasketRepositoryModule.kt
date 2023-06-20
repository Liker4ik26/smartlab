package com.compose.medicine.smartlab.database.di.modules

import com.compose.medicine.smartlab.database.data.local.BasketRepository
import com.compose.medicine.smartlab.database.data.local.BasketRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BasketRepositoryModule {

    @Binds
    fun bindBasketRepository(basketRepositoryImpl: BasketRepositoryImpl): BasketRepository
}