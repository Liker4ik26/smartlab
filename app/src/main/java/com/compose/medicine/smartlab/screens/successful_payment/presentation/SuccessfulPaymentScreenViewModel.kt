package com.compose.medicine.smartlab.screens.successful_payment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuccessfulPaymentScreenViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(SuccessfulPaymentScreenUiState.Empty)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000L)
            _state.update { it.copy(isLoading = false) }
        }
    }
}