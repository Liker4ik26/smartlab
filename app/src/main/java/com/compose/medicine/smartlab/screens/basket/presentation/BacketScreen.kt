package com.compose.medicine.smartlab.screens.basket.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.screens.basket.presentation.components.BasketItemCard
import com.compose.medicine.smartlab.screens.basket.presentation.models.BasketItemUi
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun BasketScreen(navigator: BasketNavigation) {
    BasketScreen(
        onBack = navigator::navigateBack,
        onNavigateToCheckoutScreen = navigator::navigateToCheckoutScreen
    )
}

@Composable
fun BasketScreen(
    viewModel: BasketViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onNavigateToCheckoutScreen: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is BasketUiEffect.NavigateBack -> onBack()
                is BasketUiEffect.NavigateToCheckoutScreen -> onNavigateToCheckoutScreen()
            }
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        item {
            IconButton(
                onClick = {
                    viewModel.sendEvent(BasketUiEvent.OnNavigateBack)
                },
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFFF5F5F9)),
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.chevron_left),
                    contentDescription = null
                )
            }
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Корзина",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black
                    )
                    IconButton(
                        modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                        onClick = {
                            viewModel.sendEvent(BasketUiEvent.DeleteAllAnalyzesFromBasket)
                        },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color(
                                0xFFF5F5F9
                            )
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.delete),
                            tint = Color(0xFFB8C1CC),
                            contentDescription = null
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        items(state.basketList) { item: BasketItemUi ->
            BasketItemCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFFF4F4F4), RoundedCornerShape(12.dp)),
                basketItem = item,
                onAddClick = {
                    viewModel.sendEvent(
                        BasketUiEvent.OnAddPatient(
                            id = item.id,
                            countPatient = item.countPatient,
                            basketList = item
                        )
                    )
                },
                onDeleteClick = {
                    viewModel.sendEvent(
                        BasketUiEvent.OnRemovePatient(
                            id = item.id,
                            countPatient = item.countPatient,
                            basketList = item
                        )
                    )
                },
                onBack = {},
                onDeleteAnalysisClick = {
                    viewModel.sendEvent(
                        BasketUiEvent.DeleteAnalysisToBasket(
                            id = item.id
                        )
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Сумма",
                        style = MaterialTheme.typography.displayLarge,
                        color = Color.Black
                    )
                    Text(
                        text = "${state.sum.toString().split('.')[0]} ₽",
                        style = MaterialTheme.typography.displayLarge,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                Button(modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1A6FEE),
                        disabledContainerColor = Color(0xFFC9D4FB)
                    ),
                    onClick = {
                        viewModel.sendEvent(BasketUiEvent.OnNavigateToCheckoutScreen)
                    }
                ) {
                    Text(
                        text = "Перейти к оформлению заказа",
                        color = Color.White,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}