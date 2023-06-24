package com.compose.medicine.smartlab.screens.analyzes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.medicine.smartlab.api.data.MedicRepository
import com.compose.medicine.smartlab.api.domain.CatalogDomain
import com.compose.medicine.smartlab.api.domain.CategoryDomain
import com.compose.medicine.smartlab.api.domain.NewsDomain
import com.compose.medicine.smartlab.core.entity.unpack
import com.compose.medicine.smartlab.database.data.local.BasketRepository
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.analyzes_mappers.asAnalItemUi
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.analyzes_mappers.asAnalyzesItemUi
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.analyzes_mappers.asBasketDomain
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.category_mappers.asCategoryItemUi
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.mappers.news_mappers.asNewsItemUi
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
class AnalyzesViewModel @Inject constructor(
    private val repository: BasketRepository,
    private val medicRepository: MedicRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AnalyzesUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<AnalyzesUiEffect>()
    val effect = _effect.asSharedFlow()

    init {
        _state.update { it.copy(isLoading = true) }
        count()
        loadAnalyzes()
        loadLocalAnalyzes()
        loadNews()
        loadCategory()
    }

    fun sendEvent(event: AnalyzesUiEvent) {
        when (event) {
            is AnalyzesUiEvent.OnSearchInput -> {
                viewModelScope.launch {
                    if (event.search.isNotEmpty()) {
                        _state.update {
                            it.copy(search = event.search)
                        }
                    }
                }
            }

            is AnalyzesUiEvent.OnClickClear -> {
                _state.update {
                    it.copy(search = "")
                }
            }

            is AnalyzesUiEvent.OnNavigateBack -> {
                viewModelScope.launch {
                    _effect.emit(AnalyzesUiEffect.NavigateBack)
                }
            }

            is AnalyzesUiEvent.OnNavigateToBasketScreen -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _effect.emit(AnalyzesUiEffect.NavigateToBasketScreen)
                }
            }

            is AnalyzesUiEvent.OnRetry -> {
                _state.update { it.copy(isRefreshing = true, isLoading = true) }
                loadAnalyzes()
            }

            is AnalyzesUiEvent.OnNavigateToAnalysisDetails -> {
                viewModelScope.launch {
                    _effect.emit(
                        AnalyzesUiEffect.NavigateToAnalysisDetails(
                            event.analysis
                        )
                    )
                }
            }

            is AnalyzesUiEvent.RemoveIndexChip -> {
                _state.update { it.copy(selectedCategory = 1, isLoading = true) }
                loadAnalyzes()
            }

            is AnalyzesUiEvent.AddIndexChip -> {
                _state.update { it.copy(selectedCategory = event.categoryIndex, isLoading = true) }
                loadAnalyzes()
            }

            is AnalyzesUiEvent.AddAnalysisToBasket -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _state.update { it.copy(price = it.price + event.price) }
                    repository.addBasketItemToRoom(item = event.analysis.asBasketDomain())
                    loadAnalyzes()
                }
            }

            is AnalyzesUiEvent.DeleteAnalysisToBasket -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.deleteBasketItemFromRoom(id = event.analysis.id)

                    //                    repository.getBasketItem(id = event.analysis.id)
                }
            }

            is AnalyzesUiEvent.UpdateIsSelected -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.updateIsSelected(id = event.id, isSelected = event.isSelected)
//                    loadLocalBasket()
                }
            }

            is AnalyzesUiEvent.OnSearching -> {
                searching()
            }

            is AnalyzesUiEvent.OnActiveChanged -> {
                _state.update {
                    it.copy(isActive = event.isActive)
                }
            }

//            is AnalyzesUiEvent.CoreAccount -> {
//                viewModelScope.launch {
//                    _state.update {
//                        it.copy(price = event.price)
//                    }
//                }
//            }
        }
    }

    //    private fun loadLocalBasket() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val basket = repository.getBasketFromRoom().map { basketItem ->
//                basketItem.asAnalysisUi()
//            }
//            _state.update { it.copy(analyzes = basket) }
//        }
//    }
//

    private fun loadLocalAnalyzes() {
        viewModelScope.launch(Dispatchers.IO) {
            val basket = repository.getBasketFromRoom().map { basketDomain ->
                basketDomain.asAnalItemUi()
            }
            _state.update { it.copy(analyzesFromDb = basket) }
        }
    }

    private fun loadAnalyzes() {
        viewModelScope.launch {
            medicRepository.getAnalysisCatalogPagedFlow().unpack(
                success = { data ->
                    val catalog = data.map(CatalogDomain::asAnalyzesItemUi)
                    _state.update {
                        it.copy(
                            analyzes = catalog.filter { catalogItem ->
                                catalogItem.category == state.value.selectedCategory
                            },
                            isLoading = false,
                            isRefreshing = false
                        )
                    }
                },
                error = { errorMessage ->
                    _state.update {
                        it.copy(
                            errorMessage = errorMessage.details,
                            isLoading = false,
                            isRefreshing = false
                        )
                    }
                }
            )
        }
    }

    private fun count() {
        viewModelScope.launch {
            repository.getBasketFromRoom().map { basketDomain ->
                _state.update { it.copy(price = it.price + basketDomain.price.toDouble()) }
            }
        }
    }

    private fun loadNews() {
        viewModelScope.launch {
            medicRepository.getNewsPageList().unpack(
                success = { data ->
                    val news = data.map(NewsDomain::asNewsItemUi)
                    _state.update {
                        it.copy(
                            news = news,
                            isLoading = false,
                            isRefreshing = true,
                        )
                    }
                },
                error = { errorMessage ->
                    _state.update {
                        it.copy(
                            errorMessage = errorMessage.details,
                            isLoading = false,
                            isRefreshing = false,
                        )
                    }
                }
            )
        }
    }

    private fun loadCategory() {
        viewModelScope.launch {
            medicRepository.getCategoryList().unpack(
                success = { data ->
                    val category = data.map(CategoryDomain::asCategoryItemUi)
                    _state.update {
                        it.copy(
                            category = category,
                            isLoading = false,
                            isRefreshing = false
                        )
                    }
                },
                error = { errorMessage ->
                    _state.update {
                        it.copy(
                            errorMessage = errorMessage.details,
                            isLoading = false,
                            isRefreshing = false
                        )
                    }
                }
            )
        }
    }

    private fun searching() {
        viewModelScope.launch {
            medicRepository.getAnalysisCatalogPagedFlow().unpack(
                success = { data ->
                    val searchList = data.map(CatalogDomain::asAnalyzesItemUi)
                    _state.update {
                        it.copy(
                            searchList = searchList.filter { searchItem ->
                                searchItem.name!!.contains(it.search)
                            },
                            isLoading = false,
                            isRefreshing = false,
                        )
                    }
                },
                error = { errorMessage ->
                    _state.update {
                        it.copy(
                            errorMessage = errorMessage.details,
                            isLoading = false,
                            isRefreshing = false
                        )
                    }
                }
            )
        }
    }
}