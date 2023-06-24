package com.compose.medicine.smartlab

import androidx.compose.runtime.Immutable

@Immutable
data class MainUiState(
    val showOnboard: Boolean = true
) {
    companion object {
        val Empty = MainUiState()
    }
}