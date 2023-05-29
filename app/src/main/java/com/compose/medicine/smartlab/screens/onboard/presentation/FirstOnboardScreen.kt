package com.compose.medicine.smartlab.screens.onboard.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.compose.medicine.smartlab.R

@Composable
fun FirstOnboardScreen() {
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(R.string.skip),
                    color = Color(0xff57A9FF),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Image(
                painter = painterResource(id = R.drawable.plus), contentDescription = null,
                modifier = Modifier.size(height = 164.dp, width = 168.dp)
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = stringResource(R.string.analis),
            color = Color(0xff00B712),
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(R.string.express_medicine),
            color = Color(0xff939396),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            painter = painterResource(id = R.drawable.illustration),
            contentDescription = null
        )
    }
}