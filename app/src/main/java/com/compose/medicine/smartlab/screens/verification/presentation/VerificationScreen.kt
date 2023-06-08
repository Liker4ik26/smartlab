package com.compose.medicine.smartlab.screens.verification.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.R
import java.util.Timer

@Composable
fun VerificationScreen(viewModel: VerificationViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 40.dp)
            .fillMaxWidth()
    ) {
        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFFF5F5F9)),
            modifier = Modifier
                .padding(15.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.chevron_left),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(132.dp))
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.enter_email),
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(24.dp))
            BasicTextField(
                value = state.pin,
                onValueChange = {
                    state.pin = viewModel.sendEvent(VerificationUiEvent.OnPinInput(it)).toString()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                decorationBox = {
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(4) { index ->
                            val char = when {
                                index >= state.pin.length -> ""
                                else -> state.pin[index].toString()
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .background(Color(0xFFF5F5F9))
                                    .border(
                                        1.dp,
                                        Color(0xFFEBEBEB),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .size(48.dp),
                                text = char,
                                style = MaterialTheme.typography.headlineMedium,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(horizontal = 68.dp),
                text = "Отправить код повторно можно будет через 59 секунд",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Color(0xFF939396)
            )
        }
    }
}