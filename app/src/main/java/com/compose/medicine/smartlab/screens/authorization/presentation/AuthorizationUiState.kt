package com.compose.medicine.smartlab.screens.authorization.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class AuthorizationUiState(
    val email: String = "",
    val isError: Boolean = false,
    val isEnabled: Boolean = false
) {
    companion object {
        val Empty = AuthorizationUiState()
    }
}

sealed class AuthorizationUiEvent {
    class OnEmailInput(val email: String) : AuthorizationUiEvent()
    object OnNavigateToVerificationScreen : AuthorizationUiEvent()
}

sealed class AuthorizationEffect {
    object NavigateToVerificationScreen : AuthorizationEffect()
}