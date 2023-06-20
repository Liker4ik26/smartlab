package com.compose.medicine.smartlab.screens.date_and_time.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TimeCard(title: String, isEnable: Boolean, onClick: () -> Unit) {
    Button(
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1A6FEE),
            disabledContainerColor = Color(0xFFFF5F5F9)
        ),
        enabled = isEnable,
        onClick = { onClick() }
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall,
            color = if (isEnable) Color.White else Color(0xFF7E7E9A)
        )
    }
}