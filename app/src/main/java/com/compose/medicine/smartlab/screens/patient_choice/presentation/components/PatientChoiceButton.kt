package com.compose.medicine.smartlab.screens.patient_choice.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.screens.patient_choice.presentation.models.PatientUiItem

@Composable
fun PatientChoiceButton(
    onClick: (index: Int) -> Unit,
    currentIndex: Int,
    patientUiItem: PatientUiItem,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onClick(patientUiItem.id) },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF1A6FEE),
            disabledContainerColor = Color(0xFFF5F5F9)
        )
    ) {
        Image(
            painter = if (patientUiItem.gender == 1) {
                painterResource(id = R.drawable.male)
            } else {
                painterResource(id = R.drawable.female)
            },
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = patientUiItem.patientFio,
            color = if (currentIndex == patientUiItem.id) Color.White else Color.Black,
            style = MaterialTheme.typography.displayMedium
        )
    }
}