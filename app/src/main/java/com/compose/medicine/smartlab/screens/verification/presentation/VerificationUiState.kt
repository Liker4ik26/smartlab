package com.compose.medicine.smartlab.screens.verification.presentation

import javax.annotation.concurrent.Immutable

@Immutable
data class VerificationUiState(
    var pin: String = "",
    val isError: Boolean = false
) {
    companion object {
        val Empty = VerificationUiState()
    }
}

sealed class VerificationUiEvent {
    class OnPinInput(val pin: String) : VerificationUiEvent()
    object OnNavigateToHomeScreen : VerificationUiEvent()
    object OnNavigateBack : VerificationUiEvent()
}

sealed class VerificationEffect {
    object NavigateBack : VerificationEffect()
}