package com.compose.medicine.smartlab.screens.basket.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.screens.basket.presentation.models.BasketItemUi

@Composable
fun BasketItemCard(
    basketItem: BasketItemUi,
    modifier: Modifier = Modifier,
    onAddClick: (Int) -> Unit,
    onDeleteClick: (Int) -> Unit,
    onDeleteAnalysisClick: (BasketItemUi) -> Unit,
    onBack: () -> Unit
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp, vertical = 5.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                basketItem.name?.let {
                    Text(
                        modifier = Modifier.width(275.dp),
                        text = it,
                        style = MaterialTheme.typography.displayMedium,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(
                    onClick = { onDeleteAnalysisClick(basketItem) },
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.cancel),
                        tint = Color(0xFF7E7E9A),
                        contentDescription = null
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${basketItem.price.split('.')[0]} ₽",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${basketItem.countPatient} пациент",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(14.dp))
                            .background(color = Color(0xFFF5F5F9))
                    ) {
                        IconButton(
                            onClick = { onDeleteClick(basketItem.id) },
                            modifier = Modifier
                                .background(color = Color(0xFFF5F5F9))
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.minus),
                                tint = Color(0xFF939396),
                                contentDescription = null
                            )
                        }
                        Divider(
                            modifier = Modifier
                                .height(height = 50.dp)
                                .width(width = 1.5.dp),
                            color = Color(0xFFFEBEBEB)
                        )
                        IconButton(
                            onClick = { onAddClick(basketItem.id) },
                            modifier = Modifier
                                .background(color = Color(0xFFF5F5F9))
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.plus),
                                tint = Color(0xFF939396),
                                contentDescription = null
                            )
                        }
                    }
                }

            }
        }
    }
}