package com.compose.medicine.smartlab.screens.checkout.presentation

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
class CheckoutViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(CheckoutUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<CheckoutUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: CheckoutUiEvent) {
        when (event) {
            is CheckoutUiEvent.OnNavigateToTestingAddressScreen -> {
                viewModelScope.launch {
                    _effect.emit(CheckoutUiEffect.NavigateToTestingAddressScreen)
                }
            }

            is CheckoutUiEvent.OnNavigateToDateAndTimeScreen -> {
                viewModelScope.launch {
                    _effect.emit(CheckoutUiEffect.NavigateToDateAndTimeScreen)
                }
            }

            is CheckoutUiEvent.OnNavigateToPatientCharts -> {
                viewModelScope.launch {
                    _effect.emit(CheckoutUiEffect.NavigateToPatientCharts)
                }
            }

            is CheckoutUiEvent.OnNavigateToPatientChoice -> {
                viewModelScope.launch {
                    _effect.emit(CheckoutUiEffect.NavigateToPatientChoice)
                }
            }

            is CheckoutUiEvent.OnNavigateBack -> {
                viewModelScope.launch {
                    _effect.emit(CheckoutUiEffect.NavigateBack)
                }
            }
        }
    }
}