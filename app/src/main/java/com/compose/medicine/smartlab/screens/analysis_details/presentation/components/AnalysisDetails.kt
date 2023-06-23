package com.compose.medicine.smartlab.screens.analysis_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AnalysisDetails(
    title: String?,
    description: String?,
    preparation: String?,
    result: String,
    biomaterial: String,
    price: String,
    onClick: () -> Unit,
    onAddToBasket: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            if (title != null) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.displayLarge,
                    textAlign = TextAlign.Start,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            IconButton(
                onClick = { onClick() },
                modifier = Modifier.padding(7.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    tint = Color(0xFF7E7E9A),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Описание",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Start,
            color = Color(0xFF939396)
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (description != null) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Подготовка",
            style = MaterialTheme.typography.displayMedium,
            color = Color(0xFF939396),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (preparation != null) {
            Text(
                text = preparation,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(58.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Column {
                Text(
                    text = "Результаты через: ",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Start,
                    color = Color(0xFF939396)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = result,
                    style = MaterialTheme.typography.displayMedium,
                    textAlign = TextAlign.Start,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(56.dp))
            Column {
                Text(
                    text = "Биоматериал: ",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Start,
                    color = Color(0xFF939396)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = biomaterial,
                    style = MaterialTheme.typography.displayMedium,
                    textAlign = TextAlign.Start,
                    color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        AddButton(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp), textButton = price, onClick = { onAddToBasket() })
        Spacer(modifier = Modifier.height(56.dp))
    }
}