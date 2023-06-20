package com.compose.medicine.smartlab.screens.patient_choice.presentation

import com.compose.medicine.smartlab.screens.patient_choice.presentation.models.PatientUiItem
import javax.annotation.concurrent.Immutable

@Immutable
data class PatientChoiceUiState(
    val selectedItem: Int = 0,
    val patientChoice: List<PatientUiItem> = emptyList()
) {
    companion object {
        val Empty = PatientChoiceUiState()
    }
}

sealed class PatientChoiceUiEvent {
    object OnNavigateToCheckout : PatientChoiceUiEvent()
    object OnNavigateToPatientChartsScreen : PatientChoiceUiEvent()
    class CheckChoicePatientUi(val selectedItem: Int) : PatientChoiceUiEvent()
}

sealed class PatientChoiceUiEffect {
    object NavigateToCheckout : PatientChoiceUiEffect()
    object NavigateToPatientCharts : PatientChoiceUiEffect()
}