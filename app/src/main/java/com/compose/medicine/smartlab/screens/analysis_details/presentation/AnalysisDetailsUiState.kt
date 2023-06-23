package com.compose.medicine.smartlab.screens.analysis_details.presentation

import androidx.compose.runtime.Immutable
import com.compose.medicine.smartlab.presentation.components.UiText

@Immutable
data class AnalysisDetailsUiState(
    val title: UiText? = null,
    val description: UiText? = null,
    val preparation: UiText? = null,
    val timeResult: String = "",
    val biomaterial: String = "",
    val price: String = ""
) {
    companion object {
        val Empty = AnalysisDetailsUiState()
    }
}

sealed class AnalysisDetailsUiEvent {
    object OnBack : AnalysisDetailsUiEvent()
    object OnAddToBasket : AnalysisDetailsUiEvent()
}

sealed class AnalysisDetailsUiEffect {
    object NavigateBack : AnalysisDetailsUiEffect()
}