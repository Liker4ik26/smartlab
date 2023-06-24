package com.compose.medicine.smartlab.screens.checkout.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class CheckoutUiState(
    val data: String = "",
    val phoneNumber: String = "",
    val description: String = "",
    val address: String = "",
    val dateTime: String = "",
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
    object OnNavigateBack : CheckoutUiEvent()
    object OnNavigateToSuccessfulScreen : CheckoutUiEvent()
    class OnPhoneNumberInput(val phoneNumber: String) : CheckoutUiEvent()
}

sealed class CheckoutUiEffect {
    object NavigateToTestingAddressScreen : CheckoutUiEffect()
    object NavigateToDateAndTimeScreen : CheckoutUiEffect()
    object NavigateToPatientCharts : CheckoutUiEffect()
    object NavigateToPatientChoice : CheckoutUiEffect()
    object NavigateBack : CheckoutUiEffect()
    object NavigateToSuccessfulScreen : CheckoutUiEffect()
}