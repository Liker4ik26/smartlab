package com.compose.medicine.smartlab.screens.analysis_details.presentation.components

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
fun AddButton(
    modifier: Modifier = Modifier,
    textButton: String,
    onClick: () -> Unit
) {
    Button(modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1A6FEE),
            disabledContainerColor = Color(0xFFC9D4FB)
        ),
        onClick = { onClick() }) {
        Text(
            text = "Добавить за $textButton ₽",
            color = Color.White,
            style = MaterialTheme.typography.titleSmall
        )
    }
}