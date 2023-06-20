package com.compose.medicine.smartlab.database.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.compose.medicine.smartlab.core.Constants.Companion.BASKET_TABLE
import com.compose.medicine.smartlab.database.data.local.models.BasketEntity

@Dao
interface BasketDao {
    @Query("SELECT * FROM $BASKET_TABLE ORDER BY id ASC")
    suspend fun getBasketItems(): List<BasketEntity>

//    @Query("SELECT * FROM $BASKET_TABLE WHERE id =:id")
//    suspend fun getBasketItem(id: Int)

    @Insert(entity = BasketEntity::class)
    suspend fun addBasketItem(item: BasketEntity)

    //    @Delete
    @Query("DELETE FROM $BASKET_TABLE WHERE id =:id")
    suspend fun deleteBasketItem(id: Int)

    @Query("UPDATE $BASKET_TABLE SET countPatient =:countPatient WHERE id=:id")
    suspend fun incrementPatient(id: Int, countPatient: Int)

//    @Query("UPDATE $BASKET_TABLE SET isSelected =:isSelected WHERE id=:id")
//    suspend fun updateIsSelected(id: Int, isSelected: Boolean)

    @Query("DELETE FROM $BASKET_TABLE")
    suspend fun deleteAllAnalyzes()
}