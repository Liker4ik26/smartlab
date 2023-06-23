package com.compose.medicine.smartlab.screens.analyzes.presentation

import androidx.compose.runtime.Immutable
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisDetailsNavArg
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisItemUi
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.CategoryItemUi
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.NewsAndStockItemUi

@Immutable
data class AnalyzesUiState(
    val search: String = "",
    val isError: Boolean = false,
    val price: Double = 0.0,
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val errorMessage: String? = null,
    val isActive: Boolean = false,
    val analyzes: List<AnalysisItemUi> = emptyList(),
    val analyzesFromDb: List<AnalysisItemUi> = emptyList(),
    val news: List<NewsAndStockItemUi> = emptyList(),
    val category: List<CategoryItemUi> = emptyList(),
    val searchList: List<AnalysisItemUi> = emptyList(),
    val selectedCategory: Int = 1
) {
    companion object {
        val Empty = AnalyzesUiState()
    }
}

sealed class AnalyzesUiEvent {
    object OnRetry : AnalyzesUiEvent()
    class OnSearchInput(val search: String) : AnalyzesUiEvent()
    object OnSearching : AnalyzesUiEvent()
    object OnClickClear : AnalyzesUiEvent()
    class OnActiveChanged(val isActive: Boolean) : AnalyzesUiEvent()
    object OnNavigateToBasketScreen : AnalyzesUiEvent()
    class AddIndexChip(val categoryIndex: Int) : AnalyzesUiEvent()
    class RemoveIndexChip : AnalyzesUiEvent()
    object OnNavigateBack : AnalyzesUiEvent()
    class AddAnalysisToBasket(val analysis: AnalysisItemUi, val price: Double) : AnalyzesUiEvent()
    class DeleteAnalysisToBasket(val analysis: AnalysisItemUi) : AnalyzesUiEvent()
    class UpdateIsSelected(val id: Int, val isSelected: Boolean) : AnalyzesUiEvent()
    class OnNavigateToAnalysisDetails(val analysis: AnalysisDetailsNavArg) : AnalyzesUiEvent()
}

sealed class AnalyzesUiEffect {
    object NavigateToBasketScreen : AnalyzesUiEffect()
    object NavigateBack: AnalyzesUiEffect()
    class NavigateToAnalysisDetails(val analysis: AnalysisDetailsNavArg) : AnalyzesUiEffect()
}
