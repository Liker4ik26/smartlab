package com.compose.medicine.smartlab.screens.analyzes.presentation.components

import androidx.compose.foundation.border
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisItemUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalysisCard(
    modifier: Modifier = Modifier,
    analysis: AnalysisItemUi,
    onClick: (AnalysisItemUi) -> Unit,
    onClickAdd: (AnalysisItemUi) -> Unit,
    onClickDelete: (AnalysisItemUi) -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = { onClick(analysis) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            analysis.name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.displayMedium,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = analysis.timeResult,
                        style = MaterialTheme.typography.displaySmall,
                        color = Color(0xFF939396)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = analysis.price.split('.')[0],
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Black
                    )
                }
                AnalysisCardButton(
                    modifier = Modifier
                        .border(1.dp, Color(0xFF1A6FEE), RoundedCornerShape(10.dp))
                        .width(116.dp)
                        .height(34.dp),
                    isSelected = true,
                    onClickAdd = { onClickAdd(analysis) },
                    onClickDelete = { onClickDelete(analysis) }
                )
            }
        }
    }
}