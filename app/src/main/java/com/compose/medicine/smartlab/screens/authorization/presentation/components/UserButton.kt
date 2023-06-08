package com.compose.medicine.smartlab.screens.authorization.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun UserButton(
    modifier: Modifier = Modifier,
    textButton: Int,
    onClick: () -> Unit,
    isEnabled: Boolean
) {
    Button(modifier = modifier,
        enabled = isEnabled,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1A6FEE),
            disabledContainerColor = Color(0xFFC9D4FB)
        ),
        onClick = { onClick() }) {
        Text(
            text = stringResource(id = textButton),
            color = Color.White,
            style = MaterialTheme.typography.titleSmall
        )
    }
}