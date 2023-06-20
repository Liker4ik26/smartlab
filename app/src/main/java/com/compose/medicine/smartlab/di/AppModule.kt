package com.compose.medicine.smartlab.di

import android.content.Context
import androidx.room.Room
import com.compose.medicine.smartlab.core.Constants.Companion.BASKET_TABLE
import com.compose.medicine.smartlab.database.BasketDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBasketDb(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, BasketDb::class.java, BASKET_TABLE).build()

    @Provides
    fun provideBasketDao(
        basketDb: BasketDb
    ) = basketDb.basketDao
}