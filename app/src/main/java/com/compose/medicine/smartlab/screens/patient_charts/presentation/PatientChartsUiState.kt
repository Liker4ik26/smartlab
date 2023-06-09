package com.compose.medicine.smartlab.screens.patient_charts.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class PatientChartsUiState(
    val name: String = "",
    val lastName: String = "",
    val patronymic: String = "",
    val birthdate: String = "",
    val isEnabled: Boolean = false,
    val isError: Boolean = false
) {
    companion object {
        val Empty = PatientChartsUiState()
    }
}

sealed class PatientChartsUiEvent {
    class OnNameInput(val name: String) : PatientChartsUiEvent()
    class OnLastNameInput(val lastName: String) : PatientChartsUiEvent()
    class OnPatronymicInput(val patronymic: String) : PatientChartsUiEvent()
    class OnBirthdateInput(val birthdate: String) : PatientChartsUiEvent()
    object OnNavigateToAnalyzes : PatientChartsUiEvent()
    object OnNavigateSkip : PatientChartsUiEvent()
}

sealed class PatientChartsEffect {
    object NavigateToAnalyzes : PatientChartsEffect()
    object NavigateSkip : PatientChartsEffect()
}