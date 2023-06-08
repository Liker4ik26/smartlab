package com.compose.medicine.smartlab.screens.authorization.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.screens.authorization.presentation.components.UserButton
import com.compose.medicine.smartlab.screens.authorization.presentation.components.UserTextField
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun AuthorizationScreen(navigation: AuthorizationScreenNavigation) {
    AuthorizationScreen(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        onNavigateToVerificationScreen = navigation::navigateToVerificationScreen
    )
}

@Composable
private fun AuthorizationScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthorizationViewModel = hiltViewModel(),
    onNavigateToVerificationScreen: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is AuthorizationEffect.NavigateToVerificationScreen -> onNavigateToVerificationScreen()
            }
        }
    }

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 40.dp, bottom = 25.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(painter = painterResource(id = R.drawable.hello), contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(R.string.welcome),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
        }
        Text(
            text = stringResource(R.string.enter),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = stringResource(R.string.enter_e_mail),
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black.copy(alpha = 0.5f),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(4.dp))
        UserTextField(
            modifier = Modifier.fillMaxWidth(),
            text = state.email,
            hint = stringResource(R.string.example_mail_ru),
            isError = state.isError
        ) {
            viewModel.sendEvent(AuthorizationUiEvent.OnEmailInput(it))
        }
        Spacer(modifier = Modifier.height(32.dp))
        UserButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            textButton = R.string.next,
            onClick = { viewModel.sendEvent(AuthorizationUiEvent.OnNavigateToVerificationScreen) },
            isEnabled = state.isEnabled
        )
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 20.dp, end = 20.dp, bottom = 56.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.enter_help),
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF939396)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            onClick = {},
            border = BorderStroke(1.dp, Color(0xFFEBEBEB)),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text(
                text = "Войти с Яндекс",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
        }
    }
}