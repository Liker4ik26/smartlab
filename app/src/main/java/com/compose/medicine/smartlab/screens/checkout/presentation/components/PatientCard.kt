package com.compose.medicine.smartlab.screens.checkout.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.medicine.smartlab.R

@Composable
fun PatientCard(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, color = Color(0xFFEBEBEB)),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                PatientButton(icon = R.drawable.male, text = "Тицкий Эдуард") { onClick() }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(
                    modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                    onClick = {}
                ) {
                    Icon(
                        modifier = Modifier.size(10.dp),
                        painter = painterResource(id = R.drawable.cancel),
                        tint = Color(0xFFB8C1CC),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            PatientAnalysisCard(
                isChecked = isChecked,
                onCheckedChange = { onCheckedChange() },
                analysis = "Клинический анализ крови с лейкоцитарной формулировкой",
                price = "690"
            )
            Spacer(modifier = Modifier.height(16.dp))
            PatientAnalysisCard(
                isChecked = isChecked,
                onCheckedChange = { onCheckedChange() },
                analysis = "ПЦР-тест на определение РНК коронавируса стандартный",
                price = "1800"
            )
        }
    }
}