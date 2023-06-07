package com.compose.medicine.smartlab.screens.analyzes.presentation

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
class AnalyzesViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(AnalyzesUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<AnalyzesUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: AnalyzesUiEvent) {
        when(event) {
            is AnalyzesUiEvent.OnSearchInput -> {
                viewModelScope.launch { _state.update { it.copy(search = event.search) } }
            }
            is  AnalyzesUiEvent.OnNavigateToHomeScreen -> {
                viewModelScope.launch {}
            }
        }
    }
}