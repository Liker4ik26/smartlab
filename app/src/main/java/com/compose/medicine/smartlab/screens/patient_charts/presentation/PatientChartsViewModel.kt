package com.compose.medicine.smartlab.screens.patient_charts.presentation

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
class PatientChartsViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(PatientChartsUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PatientChartsEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: PatientChartsUiEvent) {
        when (event) {
            is PatientChartsUiEvent.OnNavigateToHomeScreen -> {
                viewModelScope.launch { }
            }

            is PatientChartsUiEvent.OnNameInput -> {
                viewModelScope.launch { _state.update { it.copy(name = event.name) } }
            }

            is PatientChartsUiEvent.OnLastNameInput -> {
                viewModelScope.launch {
                    _state.update { it.copy(lastName = event.lastName) }
                }
            }

            is PatientChartsUiEvent.OnPatronymicInput -> {
                viewModelScope.launch { _state.update { it.copy(patronymic = event.patronymic) } }
            }

            is PatientChartsUiEvent.OnBirthdateInput -> {
                viewModelScope.launch { _state.update { it.copy(birthdate = event.birthdate) } }
            }
        }
    }
}