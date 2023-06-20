package com.compose.medicine.smartlab.screens.testing_address.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.core_ui.components.BodyTextFieldHint
import com.compose.medicine.smartlab.core_ui.components.InfoPatientTextField
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(style = DestinationStyle.BottomSheet::class)
@Composable
fun TestingAddressScreen(navigator: TestingAddressNavigation) {
    TestingAddressScreen(onNavigateBack = navigator::navigateBack)
}

@Composable
private fun TestingAddressScreen(
    viewModel: TestingAddressViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is TestingAddressUiEffect.NavigateBack -> onNavigateBack()
                is TestingAddressUiEffect.NavigateToCheckoutScreen -> {}
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
                text = "Адрес сдачи анализов",
                style = MaterialTheme.typography.displayLarge,
                color = Color.Black
            )
            IconButton(
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.map),
                    tint = Color(0xFFB8C1CC),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        BodyTextFieldHint(text = "Ваш адрес")
        Spacer(modifier = Modifier.height(4.dp))
        InfoPatientTextField(
            text = state.address,
            hint = "Введите ваш адрес",
            isError = state.isError,
            onType = {
                viewModel.sendEvent(TestingAddressUiEvent.OnAddressInput(it))
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            BodyTextFieldHint(text = "Долгота")
            BodyTextFieldHint(text = "Широта")
            BodyTextFieldHint(text = "Высота")
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoPatientTextField(
                text = state.longitude,
                hint = "Долгота",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                isError = state.isError,
                onType = {
                    viewModel.sendEvent(TestingAddressUiEvent.OnLongitudeInput(it))
                },
                modifier = Modifier.width(100.dp)
            )
            InfoPatientTextField(
                text = state.latitude,
                hint = "Широта",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                isError = state.isError,
                onType = {
                    viewModel.sendEvent(TestingAddressUiEvent.OnLatitudeInput(it))
                },
                modifier = Modifier.width(100.dp)
            )
            InfoPatientTextField(
                text = state.height,
                hint = "Высота",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                isError = state.isError,
                onType = {
                    viewModel.sendEvent(TestingAddressUiEvent.OnHeightInput(it))
                },
                modifier = Modifier.width(80.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            BodyTextFieldHint(text = "Квартира")
            BodyTextFieldHint(text = "Подъезд")
            BodyTextFieldHint(text = "Этаж")
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            InfoPatientTextField(
                text = state.apartment,
                hint = "Квартира",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                isError = state.isError,
                onType = {
                    viewModel.sendEvent(TestingAddressUiEvent.OnApartmentInput(it))
                },
                modifier = Modifier.width(100.dp)
            )
            InfoPatientTextField(
                text = state.entrance,
                hint = "Подъезд",
                isError = state.isError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                onType = {
                    viewModel.sendEvent(TestingAddressUiEvent.OnEntranceInput(it))
                },
                modifier = Modifier.width(100.dp)
            )
            InfoPatientTextField(
                text = state.floor,
                hint = "Этаж",
                isError = state.isError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                onType = {
                    viewModel.sendEvent(TestingAddressUiEvent.OnFloorInput(it))
                },
                modifier = Modifier.width(100.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            BodyTextFieldHint(text = "Домофон")
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            InfoPatientTextField(
                text = state.intercom,
                hint = "Домофон",
                isError = state.isError,
                onType = {
                    viewModel.sendEvent(TestingAddressUiEvent.OnIntercomInput(it))
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Сохранить этот адрес?",
                style = MaterialTheme.typography.displayLarge,
                color = Color.Black
            )
            Switch(
                checked = false, onCheckedChange = {}, colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF1A6FEE),
                    checkedBorderColor = Color(0xFF1A6FEE),
                    uncheckedBorderColor = Color.White,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color(0xFFEBEBEB)
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            enabled = state.isEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1A6FEE),
                disabledContainerColor = Color(0xFFC9D4FB)
            ),
            onClick = {
                viewModel.sendEvent(TestingAddressUiEvent.OnNavigateBack)
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