package com.compose.medicine.smartlab.database.data.local

import com.compose.medicine.smartlab.database.data.local.dao.BasketDao
import com.compose.medicine.smartlab.database.data.local.models.mappers.toBasketDomain
import com.compose.medicine.smartlab.database.domain.models.BasketDomain
import com.compose.medicine.smartlab.database.domain.models.mappers.asBasketEntity
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(private val basketDao: BasketDao) :
    BasketRepository {

    override suspend fun getBasketFromRoom(): List<BasketDomain> =
        basketDao.getBasketItems().map { item -> item.toBasketDomain() }

    override suspend fun addBasketItemToRoom(item: BasketDomain) {
        basketDao.addBasketItem(item.asBasketEntity())
    }

//    override suspend fun getBasketItem(id: Int) {
//        basketDao.getBasketItem(id = id)
//    }

    override suspend fun deleteBasketItemFromRoom(id: Int) =
        basketDao.deleteBasketItem(id = id)

    override suspend fun incrementPatient(id: Int, countPatient: Int) {
        basketDao.incrementPatient(id = id, countPatient = countPatient)
    }

    override suspend fun updateIsSelected(id: Int, isSelected: Boolean) {
        // basketDao.updateIsSelected(id = id, isSelected = isSelected)
    }

    override suspend fun deleteAllAnalyzes() {
        basketDao.deleteAllAnalyzes()
    }
}