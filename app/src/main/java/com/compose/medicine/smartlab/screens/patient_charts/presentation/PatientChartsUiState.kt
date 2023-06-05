package com.compose.medicine.smartlab.screens.patient_charts.presentation

import javax.annotation.concurrent.Immutable

@Immutable
data class PatientChartsUiState(
    val name: String = "",
    val lastName: String = "",
    val patronymic: String = "",
    val birthdate: String = "",
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
    object OnNavigateToHomeScreen : PatientChartsUiEvent()
}

sealed class PatientChartsEffect {
    object NavigateToHomeScreen : PatientChartsEffect()
}