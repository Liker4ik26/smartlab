package com.compose.medicine.smartlab.screens.checkout.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.core_ui.components.InfoPatientTextField
import com.compose.medicine.smartlab.screens.checkout.presentation.components.CheckoutButton
import com.compose.medicine.smartlab.screens.checkout.presentation.components.PatientCard
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun CheckoutScreen(navigator: CheckoutNavigation) {
    CheckoutScreen(
        onNavigateToTestingAddressScreen = navigator::navigateToTestingAddressScreen,
        onNavigateToDateAndTimeScreen = navigator::navigateToDateAndTimeScreen,
        onNavigateToPatientCharts = navigator::navigateToPatientChartsScreen,
        onNavigateToPatientChoice = navigator::navigateToPatientChoiceScreen
    )
}

@Composable
private fun CheckoutScreen(
    viewModel: CheckoutViewModel = hiltViewModel(),
    onNavigateToTestingAddressScreen: () -> Unit,
    onNavigateToDateAndTimeScreen: () -> Unit,
    onNavigateToPatientCharts: () -> Unit,
    onNavigateToPatientChoice: () -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is CheckoutUiEffect.NavigateToTestingAddressScreen -> onNavigateToTestingAddressScreen()
                is CheckoutUiEffect.NavigateToDateAndTimeScreen -> onNavigateToDateAndTimeScreen()
                is CheckoutUiEffect.NavigateToPatientCharts -> onNavigateToPatientCharts()
                is CheckoutUiEffect.NavigateToPatientChoice -> onNavigateToPatientChoice()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        IconButton(
            modifier = Modifier.padding(horizontal = 20.dp),
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFFF5F5F9)),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.chevron_left),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Оформление заказа",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Адрес *",
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF939396)
        )
        Spacer(modifier = Modifier.height(4.dp))
        CheckoutButton(
            hint = "Введите ваш адрес",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFF5F5F9))
                .border(
                    1.dp,
                    color = Color(0xFFEBEBEB),
                    shape = RoundedCornerShape(10.dp)
                ),
            onClick = { viewModel.sendEvent(CheckoutUiEvent.OnNavigateToTestingAddressScreen) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Дата и время*",
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF939396)
        )
        Spacer(modifier = Modifier.height(32.dp))
        CheckoutButton(
            hint = "Выберите дату и время",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFF5F5F9))
                .border(
                    1.dp,
                    color = Color(0xFFEBEBEB),
                    shape = RoundedCornerShape(10.dp)
                ),
            onClick = { viewModel.sendEvent(CheckoutUiEvent.OnNavigateToDateAndTimeScreen) }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Кто будет сдавать анализы?",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF939396)
            )
            Text(
                text = "*",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        PatientCard(
            isChecked = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            onCheckedChange = {}
        ) {
            viewModel.sendEvent(CheckoutUiEvent.OnNavigateToPatientChoice)
        }
        Spacer(modifier = Modifier.height(16.dp))
        PatientCard(
            isChecked = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            onCheckedChange = {}
        ) {
            viewModel.sendEvent(CheckoutUiEvent.OnNavigateToPatientChoice)
        }
        Spacer(modifier = Modifier.height(16.dp))
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
                viewModel.sendEvent(CheckoutUiEvent.OnNavigateToPatientCharts)
            }) {
            Text(
                text = "Добавить еще пациента",
                color = Color(0xFF1A6FEE),
                style = MaterialTheme.typography.titleSmall
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Телефон",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF939396)
            )
            Text(
                text = "*",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        InfoPatientTextField(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = "",
            hint = "Введите телефон",
            isError = false,
            onType = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Комментарий",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF939396)
            )
            Icon(
                painter = painterResource(id = R.drawable.micro),
                contentDescription = null
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
        )
        InfoPatientTextField(
            modifier = Modifier
                .height(128.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = "",
            hint = "Можете оставить свои пожелания",
            isError = false,
            onType = {}
        )
        Spacer(modifier = Modifier.height(60.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF5F5F9))
                .padding(horizontal = 20.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Оплата Apple Pay",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_right),
                        tint = Color(0xFFFB8C1CC),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Оплата Apple Pay",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_right),
                        tint = Color(0xFFFB8C1CC),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "3 анализа",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                    Text(
                        text = "4290 ₽",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Button(modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
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
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}