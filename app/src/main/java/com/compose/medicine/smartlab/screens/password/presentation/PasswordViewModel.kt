package com.compose.medicine.smartlab.screens.password.presentation

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.medicine.smartlab.api.data.remote.MedicRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PasswordViewModel @Inject constructor(private val repository: MedicRepositoryImpl) :
    ViewModel() {

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
                _state.update { it.copy(pin = event.pin) }
            }

            is PasswordUiEvent.OnNavigateToPatientChartsWithPassword -> {
                checkPinSingUp()
            }
        }
    }

    private fun checkPinSingUp() {
        if (_state.value.pin.isDigitsOnly()) {
            viewModelScope.launch {
//                repository.createUser(
//                    SignupDomain(
//                        password = _state.value.pin
//                    )
//                )
                _effect.emit(PasswordEffect.NavigateToPatientCharts)
            }
        }
    }
}