package com.compose.medicine.smartlab.screens.authorization.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(AuthorizationUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<AuthorizationEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: AuthorizationUiEvent) {
        when (event) {
            is AuthorizationUiEvent.OnNavigateToHomeScreen -> {
                viewModelScope.launch { }
            }

            is AuthorizationUiEvent.OnEmailInput -> {
                viewModelScope.launch { _state.update { it.copy(email = event.email) } }
            }
        }
    }
}