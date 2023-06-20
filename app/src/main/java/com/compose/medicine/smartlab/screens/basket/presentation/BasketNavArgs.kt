package com.compose.medicine.smartlab.screens.basket.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class BasketNavArgs(val basketDetails: BasketDetails)

@Parcelize
data class BasketDetails(
    val title: String?,
    val description: String?,
    val preparation: String?,
    val result: String,
    val date: String,
    val biomaterial: String,
    val price: String
) : Parcelable
