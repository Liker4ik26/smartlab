package com.compose.medicine.smartlab.screens.checkout.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class CheckoutUiState(
    val data: String = ""
) {
    companion object {
        val Empty = CheckoutUiState()
    }
}

sealed class CheckoutUiEvent {
    object OnNavigateToTestingAddressScreen : CheckoutUiEvent()
    object OnNavigateToDateAndTimeScreen : CheckoutUiEvent()
    object OnNavigateToPatientCharts : CheckoutUiEvent()
    object OnNavigateToPatientChoice : CheckoutUiEvent()
}

sealed class CheckoutUiEffect {
    object NavigateToTestingAddressScreen : CheckoutUiEffect()
    object NavigateToDateAndTimeScreen : CheckoutUiEffect()
    object NavigateToPatientCharts : CheckoutUiEffect()
    object NavigateToPatientChoice : CheckoutUiEffect()
}