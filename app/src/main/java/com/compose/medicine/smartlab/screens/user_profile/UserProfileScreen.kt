package com.compose.medicine.smartlab.screens.user_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.screens.user_profile.presentation.UserProfileUiEvent
import com.compose.medicine.smartlab.screens.user_profile.presentation.components.GenderSelectionMenu
import com.compose.medicine.smartlab.screens.user_profile.presentation.components.SaveButton
import com.compose.medicine.smartlab.screens.user_profile.presentation.components.UserProfileTextField

@Composable
fun UserProfileScreen(viewModel: UserProfileViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Column(modifier = Modifier.fillMaxWidth()) {

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Карта пациента",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(7.dp))
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clip(shape = RoundedCornerShape(60.dp))
                .background(Color(0xFFEBEBEB))
                .clickable { }
                .height(123.dp)
                .width(148.dp)
        ) {
            Image(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.photo),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = "Без карты пациента вы не сможете заказать анализы.",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Start,
            color = Color(0xFF939396)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = "В картах пациентов будут храниться результаты \n анализов вас и ваших близких.",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Start,
            color = Color(0xFF939396)
        )
        Spacer(modifier = Modifier.height(8.dp))
        UserProfileTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = state.name,
            hint = "Имя",
            isError = false,
            onType = {
                viewModel.sendEvent(UserProfileUiEvent.OnNameInput(it))
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        UserProfileTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = state.patronymic,
            hint = "Отчество",
            isError = false,
            onType = { viewModel.sendEvent(UserProfileUiEvent.OnPatronymicInput(it)) }
        )
        Spacer(modifier = Modifier.height(24.dp))
        UserProfileTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = state.lastName,
            hint = "Фамилия",
            isError = false,
            onType = { viewModel.sendEvent(UserProfileUiEvent.OnLastNameInput(it)) }
        )
        Spacer(modifier = Modifier.height(24.dp))
        UserProfileTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = state.birthdate,
            hint = "Дата рождения",
            isError = false,
            onType = { viewModel.sendEvent(UserProfileUiEvent.OnBirthdateInput(it)) }
        )
        Spacer(modifier = Modifier.height(24.dp))
        GenderSelectionMenu(modifier = Modifier.padding(horizontal = 20.dp))
        Spacer(modifier = Modifier.height(48.dp))
        SaveButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 20.dp),
            textButton = stringResource(R.string.save),
            onClick = { /*TODO*/ }
        )
    }
}