package com.compose.medicine.smartlab.screens.analysis_details.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class AnalysisDetailsNavArgs(val analysisDetails: AnalysisDetails)

@Parcelize
data class AnalysisDetails(
    val id: Int,
    val cardId: Int,
    val title: String?,
    val description: String?,
    val preparation: String?,
    val timeResult: String,
    val category: Int,
    val biomaterial: String,
    val price: String
) : Parcelable