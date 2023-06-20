package com.compose.medicine.smartlab.screens.analyzes.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnalysisCardButton(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClickAdd: () -> Unit,
    onClickDelete: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor =
            if (!isSelected) {
                Color(0xFF1A6FEE)
            } else {
                Color.White
            }
        ),
        onClick = {
            if (!isSelected) {
                onClickAdd()
            } else {
                onClickDelete()
            }
        }
    ) {
        if (!isSelected) {
            Text(
                text = "Добавить",
                style = MaterialTheme.typography.displaySmall,
                color = Color.White
            )
        } else {
            Text(
                text = "Убрать",
                style = MaterialTheme.typography.displaySmall,
                color = Color(0xFF1A6FEE)
            )
        }
    }
}