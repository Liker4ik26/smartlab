package com.compose.medicine.smartlab.screens.basket.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.medicine.smartlab.database.data.local.BasketRepository
import com.compose.medicine.smartlab.screens.basket.presentation.models.mappers.asItemUi
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
class BasketViewModel @Inject constructor(
    private val repository: BasketRepository
) : ViewModel() {

    init {
        loadBasket()
        accountingSum()
    }

    private val _state = MutableStateFlow(BasketUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<BasketUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: BasketUiEvent) {
        when (event) {
            is BasketUiEvent.OnAddPatient -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.incrementPatient(
                        id = event.id,
                        countPatient = event.countPatient + 1
                    )
                    _state.update { it.copy(sum = _state.value.sum + (event.countPatient * event.basketList.price.toDouble())) }
                    loadBasket()
                }
            }

            is BasketUiEvent.OnSumCalculation -> {}
            is BasketUiEvent.OnRemovePatient -> {
                viewModelScope.launch(Dispatchers.IO) {
                    if (event.countPatient > 1) {
                        repository.incrementPatient(
                            id = event.id,
                            countPatient = event.countPatient - 1
                        )
                        _state.update { it.copy(sum = _state.value.sum - event.basketList.price.toDouble()) }
                        loadBasket()
                    }

                }
            }

            is BasketUiEvent.OnNavigateToCheckoutScreen -> {
                viewModelScope.launch { _effect.emit(BasketUiEffect.NavigateToCheckoutScreen) }
            }

            is BasketUiEvent.OnNavigateBack -> {
                viewModelScope.launch { _effect.emit(BasketUiEffect.NavigateBack) }
            }

            is BasketUiEvent.DeleteAnalysisToBasket -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.deleteBasketItemFromRoom(id = event.id)
                    loadBasket()
                }
            }

            is BasketUiEvent.DeleteAllAnalyzesFromBasket -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.deleteAllAnalyzes()
                    loadBasket()
                }
            }
        }
    }

    private fun loadBasket() {
        viewModelScope.launch(Dispatchers.IO) {
            val basket = repository.getBasketFromRoom().map { basketItem ->
                basketItem.asItemUi()
            }
            _state.update { it.copy(basketList = basket) }
        }
    }

    private fun accountingSum() {
        viewModelScope.launch {
            repository.getBasketFromRoom().map { basketDomain ->
                basketDomain.asItemUi()
                _state.update { it.copy(sum = _state.value.sum + basketDomain.price.toDouble()) }
            }
        }
    }
}
