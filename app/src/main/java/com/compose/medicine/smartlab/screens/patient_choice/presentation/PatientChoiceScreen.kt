package com.compose.medicine.smartlab.screens.patient_choice.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.screens.patient_choice.presentation.components.PatientChoiceButton
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(style = DestinationStyle.BottomSheet::class)
@Composable
fun PatientChoiceScreen(navigation: PatientChoiceNavigation) {
    PatientChoiceScreen(
        onNavigateToPatientCharts = navigation::navigateToPatientChartsScreen,
        onNavigateToCheckout = navigation::navigateToCheckoutScreen
    )
}

@Composable
private fun PatientChoiceScreen(
    viewModel: PatientChoiceViewModel = hiltViewModel(),
    onNavigateToPatientCharts: () -> Unit,
    onNavigateToCheckout: () -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is PatientChoiceUiEffect.NavigateToPatientCharts -> onNavigateToPatientCharts()
                is PatientChoiceUiEffect.NavigateToCheckout -> onNavigateToCheckout()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Выбор пациента",
                style = MaterialTheme.typography.displayLarge,
                color = Color.Black
            )
            IconButton(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(8.dp)),
                onClick = {
                    viewModel.sendEvent(PatientChoiceUiEvent.OnNavigateToCheckout)
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0x4BB8C1CC)
                )
            ) {
                Icon(
                    modifier = Modifier.size(10.dp),
                    painter = painterResource(id = R.drawable.cancel),
                    tint = Color(0xFFFF7E7E9A),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth(), userScrollEnabled = false) {
            items(state.patientChoice) { item ->
                PatientChoiceButton(onClick = {
                    viewModel.sendEvent(PatientChoiceUiEvent.CheckChoicePatientUi(selectedItem = it))
                }, currentIndex = state.selectedItem, patientUiItem = item)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(56.dp)
            .border(
                1.dp,
                color = Color(0xFF1A6FEE),
                shape = RoundedCornerShape(10.dp)
            ),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            onClick = {
                viewModel.sendEvent(PatientChoiceUiEvent.OnNavigateToPatientChartsScreen)
            }) {
            Text(
                text = "Добавить еще пациента",
                color = Color(0xFF1A6FEE),
                style = MaterialTheme.typography.titleSmall
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1A6FEE),
                disabledContainerColor = Color(0xFFC9D4FB)
            ),
            onClick = {
                viewModel.sendEvent(PatientChoiceUiEvent.OnNavigateToCheckout)
            }
        ) {
            Text(
                text = "Подтвердить",
                color = Color.White,
                style = MaterialTheme.typography.titleSmall
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}