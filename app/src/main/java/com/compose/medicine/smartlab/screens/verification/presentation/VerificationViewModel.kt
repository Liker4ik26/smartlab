package com.compose.medicine.smartlab.screens.verification.presentation

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
class VerificationViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(VerificationUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<VerificationEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: VerificationUiEvent) {
        when (event) {
            is VerificationUiEvent.OnNavigateToHomeScreen -> {
                viewModelScope.launch { }
            }

            is VerificationUiEvent.OnPinInput -> {
                viewModelScope.launch {
                    _state.update { it.copy(pin = event.pin) }
                }
            }

            is VerificationUiEvent.OnNavigateBack -> {
                viewModelScope.launch { }
            }
        }
    }
}