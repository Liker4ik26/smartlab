package com.compose.medicine.smartlab.screens.successful_payment.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.medicine.smartlab.R
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun SuccessfulPaymentScreen() {
    SuccessfulPaymentScreen(s = "")
}

@Composable
private fun SuccessfulPaymentScreen(s: String) {
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Оплата", style = MaterialTheme.typography.displayLarge, color = Color.Black)
        Spacer(modifier = Modifier.height(90.dp))
        Image(
            modifier = Modifier.size(height = 220.dp, width = 360.dp),
            painter = painterResource(id = R.drawable.illustration),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Ваш заказ успешно оплачен!",
            style = MaterialTheme.typography.displayLarge,
            color = Color(0xFFF00B712)
        )
    }
}