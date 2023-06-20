package com.compose.medicine.smartlab.screens.analysis_details.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.medicine.smartlab.presentation.components.UiText
import com.compose.medicine.smartlab.screens.destinations.AnalysisDetailsScreenDestination
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class AnalysisDetailsViewModel @AssistedInject constructor(@Assisted private val savedStateHandle: SavedStateHandle) :
    ViewModel() {
    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): AnalysisDetailsViewModel
    }

    private val _state = MutableStateFlow(AnalysisDetailsUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<AnalysisDetailsUiEffect>()
    val effect = _effect.asSharedFlow()

    init {
        obtainDetails()
    }

    fun sendEvent(event: AnalysisDetailsUiEvent) {
        when (event) {
            AnalysisDetailsUiEvent.onBack -> {
                viewModelScope.launch {
                    _effect.emit(AnalysisDetailsUiEffect.NavigateBack)
                }
            }
        }
    }

    private fun obtainDetails() {
        val analysisDetails: AnalysisDetails =
            AnalysisDetailsScreenDestination.argsFrom(savedStateHandle).analysisDetails
        with(analysisDetails) {
            _state.update {
                it.copy(
                    title = if (title != null) {
                        UiText.DynamicString(title)
                    } else null,
                    description = if (description != null) {
                        UiText.DynamicString(description)
                    } else null,
                    preparation = if (preparation != null) {
                        UiText.DynamicString(preparation)
                    } else null,
                    timeResult = timeResult,
                    biomaterial = biomaterial,
                    price = price
                )
            }
        }
    }
}