package com.compose.medicine.smartlab.screens.password.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class PasswordUiState(
    val pin: String = ""
) {
    companion object {
        val Empty = PasswordUiState()
    }
}

sealed class PasswordUiEvent {
    class OnNameInput(val pin: String) : PasswordUiEvent()
    object OnNavigateToPatientCharts : PasswordUiEvent()
    object OnNavigateToPatientChartsWithPassword : PasswordUiEvent()

}

sealed class PasswordEffect {
    object NavigateToPatientCharts : PasswordEffect()
}