package com.compose.medicine.smartlab.screens.successful_payment.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
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
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {
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
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Вам осталось дождаться приезда медсестры \n и сдать анализы. До скорой встречи!",
            color = Color(0xFF939396),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Не забудьте ознакомиться с ",
                color = Color(0xFF939396),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
            TextButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.rules),
                    contentDescription = null
                )
                Text(
                    text = "правилами \n подготовки к сдаче анализов",
                    color = Color(0xFFF1A6FEE),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
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
                onClick = {}
            ) {
                Text(
                    text = "Чек покупки",
                    color = Color(0xFF1A6FEE),
                    style = MaterialTheme.typography.titleSmall
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A6FEE),
                    disabledContainerColor = Color(0xFFC9D4FB)
                ),
                onClick = {}
            ) {
                Text(
                    text = "На главную",
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}