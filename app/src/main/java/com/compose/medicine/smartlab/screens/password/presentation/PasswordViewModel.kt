package com.compose.medicine.smartlab.screens.password.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PasswordViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(PasswordUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PasswordEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: PasswordUiEvent) {
        when (event) {
            is PasswordUiEvent.OnNavigateToPatientCharts -> {
                viewModelScope.launch {
                    _effect.emit(PasswordEffect.NavigateToPatientCharts)
                }
            }

            is PasswordUiEvent.OnNameInput -> {

            }
        }
    }
}