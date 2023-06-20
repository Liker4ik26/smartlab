package com.compose.medicine.smartlab.screens.password.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.screens.password.presentation.components.PinLock
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun PasswordScreen(
    navigation: PasswordNavigation
) {
    PasswordScreen(onNavigateToPatientCharts = navigation::navigateToPatientChartsScreen)
}


@Composable
private fun PasswordScreen(
    viewModel: PasswordViewModel = hiltViewModel(),
    onNavigateToPatientCharts: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is PasswordEffect.NavigateToPatientCharts -> onNavigateToPatientCharts()
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {
                viewModel.sendEvent(PasswordUiEvent.OnNavigateToPatientCharts)
            }) {
                Text(
                    text = "Пропустить",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFF1A6FEE)
                )

            }
        }

        PinLock(title = { pinExists ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = if (pinExists) "Создайте пароль" else "Введите пароль",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Для защиты ваших персональных данных",
                    color = Color(0xFF939396),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(56.dp))
        }, color = Color(0xFFFEFEFE), onPinCorrect = { /*TODO*/ }, onPinIncorrect = { /*TODO*/ }) {
        }
    }
}