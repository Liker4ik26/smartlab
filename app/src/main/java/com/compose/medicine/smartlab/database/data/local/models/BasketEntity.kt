package com.compose.medicine.smartlab.database.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.compose.medicine.smartlab.core.Constants.Companion.BASKET_TABLE

@Entity(tableName = BASKET_TABLE)
data class BasketEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cardId: Int,
    val isSelected: Boolean = false,
    val timeResult: String,
    val name: String?,
    val price: String,
    val countPatient: Int = 1,
    val description: String?,
    val preparation: String?,
    val biomaterial: String,
    val category: Int,
)