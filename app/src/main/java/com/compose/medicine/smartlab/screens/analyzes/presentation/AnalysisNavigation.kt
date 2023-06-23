package com.compose.medicine.smartlab.screens.analyzes.presentation

import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisDetailsNavArg

interface AnalysisNavigation {
    fun openAnalysisDetails(analysisDetailsNavArg: AnalysisDetailsNavArg)
    fun navigateToBasketScreen()
    fun navigateBack()
}