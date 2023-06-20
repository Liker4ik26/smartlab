package com.compose.medicine.smartlab.screens.basket.presentation

import androidx.compose.runtime.Immutable
import com.compose.medicine.smartlab.screens.basket.presentation.models.BasketItemUi

@Immutable
data class BasketUiState(
    val price: String = "",
    val sum: Double = 0.0,
    val basketList: List<BasketItemUi> = emptyList()

) {
    companion object {
        val Empty = BasketUiState()
    }
}

sealed class BasketUiEvent {
    class OnAddPatient(val id: Int, val countPatient: Int, val basketList: BasketItemUi) :
        BasketUiEvent()

    class OnRemovePatient(val id: Int, val countPatient: Int, val basketList: BasketItemUi) :
        BasketUiEvent()

    object DeleteAllAnalyzesFromBasket : BasketUiEvent()
    class OnSumCalculation(val sum: Int, val price: String) : BasketUiEvent()
    class DeleteAnalysisToBasket(val id: Int) : BasketUiEvent()
    object OnNavigateToCheckoutScreen : BasketUiEvent()
    object OnNavigateBack : BasketUiEvent()
}

sealed class BasketUiEffect {
    object NavigateToCheckoutScreen : BasketUiEffect()
    object NavigateBack : BasketUiEffect()
}