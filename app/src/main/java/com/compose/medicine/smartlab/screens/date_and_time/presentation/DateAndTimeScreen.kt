package com.compose.medicine.smartlab.screens.date_and_time.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.medicine.smartlab.screens.date_and_time.presentation.components.DateSelectionMenu
import com.compose.medicine.smartlab.screens.date_and_time.presentation.components.TimeCard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(style = DestinationStyle.BottomSheet::class)
@Composable
fun DateAndTimeScreen() {
    DateAndTimeScreen(s = "")
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun DateAndTimeScreen(viewModel: DateAndTimeViewModel = hiltViewModel(), s: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Дата и время",
            style = MaterialTheme.typography.displayLarge,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Выберите дату",
            style = MaterialTheme.typography.displayMedium,
            color = Color(0xFFF939396)
        )
        Spacer(modifier = Modifier.height(16.dp))
        DateSelectionMenu()
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Выберите время",
            style = MaterialTheme.typography.displayMedium,
            color = Color(0xFFF939396)
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TimeCard(title = "10:00", isEnable = true) {}
            TimeCard(title = "11:00", isEnable = false) {}
            TimeCard(title = "12:00", isEnable = false) {}
            TimeCard(title = "13:00", isEnable = false) {}
            TimeCard(title = "14:30", isEnable = false) {}
            TimeCard(title = "16:00", isEnable = false) {}
        }
        Spacer(modifier = Modifier.height(48.dp))
        Button(modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1A6FEE),
                disabledContainerColor = Color(0xFFC9D4FB)
            ),
            onClick = {
            }
        ) {
            Text(
                text = "Подтвердить",
                color = Color.White,
                style = MaterialTheme.typography.titleSmall
            )
        }
        Spacer(modifier = Modifier.height(45.dp))
    }
}