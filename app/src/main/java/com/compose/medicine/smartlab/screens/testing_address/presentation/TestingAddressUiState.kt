package com.compose.medicine.smartlab.screens.testing_address.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class TestingAddressUiState(
    val address: String = "",
    val longitude: String = "",
    val latitude: String = "",
    val height: String = "",
    val entrance: String = "",
    val apartment: String = "",
    val floor: String = "",
    val intercom: String = "",
    val isError: Boolean = false,
    val isEnabled: Boolean = false
) {
    companion object {
        val Empty = TestingAddressUiState()
    }
}

sealed class TestingAddressUiEvent {
    class OnAddressInput(val address: String) : TestingAddressUiEvent()
    class OnLongitudeInput(val longitude: String) : TestingAddressUiEvent()
    class OnLatitudeInput(val latitude: String) : TestingAddressUiEvent()
    class OnHeightInput(val height: String) : TestingAddressUiEvent()
    class OnEntranceInput(val entrance: String) : TestingAddressUiEvent()
    class OnFloorInput(val floor: String) : TestingAddressUiEvent()
    class OnIntercomInput(val intercom: String) : TestingAddressUiEvent()
    class OnApartmentInput(val apartment: String) : TestingAddressUiEvent()
    object OnNavigateBack : TestingAddressUiEvent()
}

sealed class TestingAddressUiEffect {
    object NavigateToCheckoutScreen : TestingAddressUiEffect()
    object NavigateBack : TestingAddressUiEffect()
}