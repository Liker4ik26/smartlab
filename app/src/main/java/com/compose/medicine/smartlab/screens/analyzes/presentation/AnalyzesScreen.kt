package com.compose.medicine.smartlab.screens.analyzes.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.screens.analyzes.presentation.components.AnalysisCard
import com.compose.medicine.smartlab.screens.analyzes.presentation.components.CategoryCard
import com.compose.medicine.smartlab.screens.analyzes.presentation.components.NewsAndStockCard
import com.compose.medicine.smartlab.screens.analyzes.presentation.components.SearchTextField
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisDetailsNavArg
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.asNavArg
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun AnalyzesScreen(navigation: AnalysisNavigation) {
    AnalyzesScreen(
        openDetails = navigation::openAnalysisDetails,
        onNavigateToBasketScreen = navigation::navigateToBasketScreen
    )
}

@Composable
private fun AnalyzesScreen(
    openDetails: (AnalysisDetailsNavArg) -> Unit,
    onNavigateToBasketScreen: () -> Unit,
    viewModel: AnalyzesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is AnalyzesUiEffect.NavigateToAnalysisDetails -> openDetails(effect.analysis)
                is AnalyzesUiEffect.NavigateToBasketScreen -> onNavigateToBasketScreen()
            }
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
        onRefresh = { viewModel.sendEvent(AnalyzesUiEvent.OnRetry) },
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color(0xFF1A6FEE)
                )
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFF9F9FC))
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    SearchTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        text = state.search,
                        hint = "Искать анализы",
                        isError = false,
                        onType = { viewModel.sendEvent(AnalyzesUiEvent.OnSearchInput(it)) })
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        text = "Акции и новости",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(0xFF939396)
                    )

                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        items(state.news) { newsItem ->
                            NewsAndStockCard(
                                title = newsItem.name,
                                description = newsItem.description,
                                price = newsItem.price,
                                image = newsItem.image
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        text = "Каталог анализов",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(0xFF939396)
                    )

                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 20.dp)
                    ) {
                        items(state.category) { categoryItem ->
                            CategoryCard(
                                categoryItemUi = categoryItem,
                                onAdd = {
                                    viewModel.sendEvent(
                                        AnalyzesUiEvent.AddIndexChip(
                                            categoryItem.id
                                        )
                                    )
                                },
                                onRemove = {
                                    viewModel.sendEvent(
                                        AnalyzesUiEvent.RemoveIndexChip(
                                            categoryItem.id
                                        )
                                    )
                                },
                                selectedCategory = state.selectedCategory
                            )
                        }
                    }
                    for (analysis in state.analyzes) {
                        Spacer(modifier = Modifier.height(8.dp))
                        AnalysisCard(
                            analysis = analysis,
                            onClick = {
                                viewModel.sendEvent(
                                    AnalyzesUiEvent.OnNavigateToAnalysisDetails(
                                        it.asNavArg()
                                    )
                                )
                            },
                            onClickAdd = {
                                viewModel.sendEvent(
                                    AnalyzesUiEvent.AddAnalysisToBasket(
                                        it,
                                        price = analysis.price.toDouble()
                                    )
                                )
                            },
                            onClickDelete = {
                                AnalyzesUiEvent.DeleteAnalysisToBasket(
                                    it,
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(90.dp))
                }
                val selected = true
                if (selected) {
                    Box(
                        modifier = Modifier
                            .background(color = Color.White)
                            .height(90.dp)
                            .border(1.5.dp, color = Color(0xFFF4F4F4))
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()

                    ) {
                        Button(modifier = Modifier
                            .height(80.dp)
                            .align(Alignment.BottomCenter)
                            .zIndex(1f)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 10.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF1A6FEE),
                                disabledContainerColor = Color(0xFFC9D4FB)
                            ),
                            onClick = {
                                viewModel.sendEvent(AnalyzesUiEvent.OnNavigateToBasketScreen)
                            }
                        ) {
                            Spacer(modifier = Modifier.width(16.dp))
                            Icon(
                                imageVector = Icons.Outlined.ShoppingCart,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "В корзину",
                                color = Color.White,
                                style = MaterialTheme.typography.titleSmall
                            )
                            Spacer(modifier = Modifier.width(70.dp))
                            Text(
                                text = "${
                                    state.price.toString().split('.')[0]
                                } ₽",
                                color = Color.White,
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }
                }
            }
        }
    }
}