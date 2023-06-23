package com.compose.medicine.smartlab.screens.analysis_details.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.medicine.smartlab.database.data.local.BasketRepository
import com.compose.medicine.smartlab.database.domain.models.BasketDomain
import com.compose.medicine.smartlab.presentation.components.UiText
import com.compose.medicine.smartlab.screens.analysis_details.presentation.models.mappers.toBasketDomain
import com.compose.medicine.smartlab.screens.destinations.AnalysisDetailsScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnalysisDetailsViewModel @Inject constructor(
    private val repository: BasketRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
//    @AssistedFactory
//    interface Factory {
//        fun create(savedStateHandle: SavedStateHandle): AnalysisDetailsViewModel
//    }

    private val _state = MutableStateFlow(AnalysisDetailsUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<AnalysisDetailsUiEffect>()
    val effect = _effect.asSharedFlow()

    init {
        obtainDetails()
    }

    fun sendEvent(event: AnalysisDetailsUiEvent) {
        when (event) {
            AnalysisDetailsUiEvent.OnBack -> {
                viewModelScope.launch {
                    _effect.emit(AnalysisDetailsUiEffect.NavigateBack)
                }
            }

            AnalysisDetailsUiEvent.OnAddToBasket -> {
                val basketDomain: BasketDomain =
                    AnalysisDetailsScreenDestination.argsFrom(savedStateHandle).analysisDetails
                        .toBasketDomain()
                viewModelScope.launch(Dispatchers.IO) {
                    repository.addBasketItemToRoom(basketDomain)
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