package com.compose.medicine.smartlab.screens.patient_choice.presentation

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
class PatientChoiceViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(PatientChoiceUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PatientChoiceUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: PatientChoiceUiEvent) {
        when (event) {
            is PatientChoiceUiEvent.CheckChoicePatientUi -> {
                _state.update {
                    it.copy(selectedItem = event.selectedItem)
                }
            }

            is PatientChoiceUiEvent.OnNavigateToPatientChartsScreen -> {
                viewModelScope.launch {
                    _effect.emit(PatientChoiceUiEffect.NavigateToPatientCharts)
                }
            }

            is PatientChoiceUiEvent.OnNavigateToCheckout -> {
                viewModelScope.launch {
                    _effect.emit(PatientChoiceUiEffect.NavigateToCheckout)
                }
            }
        }
    }
}