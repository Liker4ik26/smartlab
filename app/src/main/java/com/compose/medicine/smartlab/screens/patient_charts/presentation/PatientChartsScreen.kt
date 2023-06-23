package com.compose.medicine.smartlab.screens.patient_charts.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.core_ui.components.InfoPatientTextField
import com.compose.medicine.smartlab.screens.patient_charts.presentation.components.CreateButton
import com.compose.medicine.smartlab.screens.patient_charts.presentation.components.GenderSelectionMenu
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun PatientChartsScreen(navigation: PatientChartsNavigation) {
    PatientChartsScreen(
        onNavigateToAnalyzes = navigation::navigateToAnalyzesScreen,
        onNavigateSkip = navigation::navigateToAnalyzesScreen
    )
}

@Composable
private fun PatientChartsScreen(
    viewModel: PatientChartsViewModel = hiltViewModel(),
    onNavigateToAnalyzes: () -> Unit,
    onNavigateSkip: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is PatientChartsEffect.NavigateToAnalyzes -> onNavigateToAnalyzes()
                is PatientChartsEffect.NavigateSkip -> onNavigateSkip()
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.create_patient_charts),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            TextButton(onClick = { viewModel.sendEvent(PatientChartsUiEvent.OnNavigateSkip) }) {
                Text(
                    text = "Пропустить",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFF1A6FEE)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.you_can_not_order_tests),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Start,
            color = Color(0xFF939396)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.save_patient_charts),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Start,
            color = Color(0xFF939396)
        )
        Spacer(modifier = Modifier.height(32.dp))
        InfoPatientTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.name,
            hint = "Имя",
            isError = state.isError,
            onType = {
                viewModel.sendEvent(PatientChartsUiEvent.OnNameInput(it))
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        InfoPatientTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.patronymic,
            hint = "Отчество",
            isError = state.isError,
            onType = { viewModel.sendEvent(PatientChartsUiEvent.OnPatronymicInput(it)) }
        )
        Spacer(modifier = Modifier.height(24.dp))
        InfoPatientTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.lastName,
            hint = "Фамилия",
            isError = state.isError,
            onType = { viewModel.sendEvent(PatientChartsUiEvent.OnLastNameInput(it)) }
        )
        Spacer(modifier = Modifier.height(24.dp))
        InfoPatientTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.birthdate,
            hint = "Дата рождения",
            isError = state.isError,
            onType = { viewModel.sendEvent(PatientChartsUiEvent.OnBirthdateInput(it)) }
        )
        Spacer(modifier = Modifier.height(24.dp))
        GenderSelectionMenu(
            label = state.label,
            onValueChange = { viewModel.sendEvent(PatientChartsUiEvent.OnGenderInput(it)) },
            onClick = { viewModel.sendEvent(PatientChartsUiEvent.OnLabelInput(it)) }
        )
        Spacer(modifier = Modifier.height(48.dp))
        CreateButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            textButton = R.string.create,
            onClick = { viewModel.sendEvent(PatientChartsUiEvent.OnNavigateToAnalyzes) },
            isEnabled = state.isEnabled
        )
    }
}