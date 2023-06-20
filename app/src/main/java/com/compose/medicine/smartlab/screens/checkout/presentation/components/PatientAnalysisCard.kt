package com.compose.medicine.smartlab.screens.checkout.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PatientAnalysisCard(
    isChecked: Boolean,
    onCheckedChange: () -> Unit,
    analysis: String,
    price: String
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { onCheckedChange() },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF1A6FEE),
                checkmarkColor = Color.White,
                uncheckedColor = Color.White
            )
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            modifier = Modifier.width(220.dp),
            text = analysis,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = "$price ₽",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}