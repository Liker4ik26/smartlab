package com.compose.medicine.smartlab.screens.authorization.presentation

import javax.annotation.concurrent.Immutable

@Immutable
data class AuthorizationUiState(
    val email: String = "",
    val isError: Boolean = false
) {
    companion object {
        val Empty = AuthorizationUiState()
    }
}

sealed class AuthorizationUiEvent {
    class OnEmailInput(val email: String) : AuthorizationUiEvent()
    object OnNavigateToHomeScreen : AuthorizationUiEvent()
}

sealed class AuthorizationEffect {
    object NavigateToHomeScreen : AuthorizationEffect()
}