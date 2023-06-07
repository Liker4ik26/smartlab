package com.compose.medicine.smartlab.screens.analyzes.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class AnalyzesUiState(
    val search: String = "",
    val isError: Boolean = false
) {
    companion object {
        val Empty = AnalyzesUiState()
    }
}

sealed class AnalyzesUiEvent {
    class OnSearchInput(val search: String) : AnalyzesUiEvent()
    object OnNavigateToHomeScreen : AnalyzesUiEvent()
}

sealed class AnalyzesUiEffect {
    object NavigateToHomeScreen : AnalyzesUiEffect()
}