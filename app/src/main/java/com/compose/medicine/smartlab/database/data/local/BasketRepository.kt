package com.compose.medicine.smartlab.database.data.local

import com.compose.medicine.smartlab.database.domain.models.BasketDomain

interface BasketRepository {

    suspend fun getBasketFromRoom(): List<BasketDomain>

    suspend fun addBasketItemToRoom(item: BasketDomain)

    suspend fun getBasketItem(cardId: Int): Int?

    suspend fun deleteBasketItemFromRoom(id: Int)

    suspend fun incrementPatient(id: Int, countPatient: Int)

    suspend fun updateIsSelected(id: Int, isSelected: Boolean)

    suspend fun deleteAllAnalyzes()
}
