package com.compose.medicine.smartlab.screens.patient_charts.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoPatientTextField(
    text: String,
    modifier: Modifier = Modifier,
    hint: String,
    isError: Boolean,
    onType: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = { onType(it) },
        placeholder = { BodyTextFieldHint(text = hint) },
        singleLine = true,
        isError = isError,
        maxLines = 1,
        modifier = modifier.border(
            1.dp,
            color = if (isError) Color.Red else Color(0xFFEBEBEB), shape = RoundedCornerShape(10.dp)
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            containerColor = Color(0xFFF5F5F9),
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorTextColor = Color.Red
        )
    )
}