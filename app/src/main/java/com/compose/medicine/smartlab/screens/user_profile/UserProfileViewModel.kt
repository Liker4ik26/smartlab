package com.compose.medicine.smartlab.screens.user_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.medicine.smartlab.screens.user_profile.presentation.UserProfileEffect
import com.compose.medicine.smartlab.screens.user_profile.presentation.UserProfileUiEvent
import com.compose.medicine.smartlab.screens.user_profile.presentation.UserProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(UserProfileUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<UserProfileEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: UserProfileUiEvent) {
        when (event) {
            is UserProfileUiEvent.OnNavigateToHomeScreen -> {
                viewModelScope.launch { }
            }

            is UserProfileUiEvent.OnNameInput -> {
                viewModelScope.launch { _state.update { it.copy(name = event.name) } }
            }

            is UserProfileUiEvent.OnPatronymicInput -> {
                viewModelScope.launch { _state.update { it.copy(patronymic = event.patronymic) } }
            }

            is UserProfileUiEvent.OnLastNameInput -> {
                viewModelScope.launch {
                    _state.update { it.copy(lastName = event.lastName) }
                }
            }

            is UserProfileUiEvent.OnBirthdateInput -> {
                viewModelScope.launch { _state.update { it.copy(birthdate = event.birthdate) } }
            }
        }
    }
}