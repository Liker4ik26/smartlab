package com.compose.medicine.smartlab.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.compose.medicine.smartlab.database.data.local.dao.BasketDao
import com.compose.medicine.smartlab.database.data.local.models.BasketEntity

@Database(entities = [BasketEntity::class], version = 1, exportSchema = false)
abstract class BasketDb : RoomDatabase() {
    abstract val basketDao: BasketDao
}