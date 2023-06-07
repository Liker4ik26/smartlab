package com.compose.medicine.smartlab.screens.user_profile.presentation

import androidx.compose.runtime.Immutable


@Immutable
data class UserProfileUiState(
    val name: String = "",
    val lastName: String = "",
    val patronymic: String = "",
    val birthdate: String = "",
    val isError: Boolean = false
) {
    companion object {
        val Empty = UserProfileUiState()
    }
}

sealed class UserProfileUiEvent {
    class OnNameInput(val name: String) : UserProfileUiEvent()
    class OnLastNameInput(val lastName: String) : UserProfileUiEvent()
    class OnPatronymicInput(val patronymic: String) : UserProfileUiEvent()
    class OnBirthdateInput(val birthdate: String) : UserProfileUiEvent()
    object OnNavigateToHomeScreen : UserProfileUiEvent()
}

sealed class UserProfileEffect {
    object NavigateToHomeScreen : UserProfileEffect()
}