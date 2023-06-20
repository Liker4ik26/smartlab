package com.compose.medicine.smartlab.screens.analyzes.presentation.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun NewsAndStockCard(
    title: String,
    description: String,
    price: String,
    image: String
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF76B3FF),
                        Color(0xFFCDE3FF)
                    )
                )
            )
            .height(180.dp)
            .width(300.dp)

    ) {
        if (image != null) {
            ImageWithPlaceHolder(
                imageUrl = image,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            )
        }
//        Image(
//            modifier = Modifier.align(Alignment.BottomEnd),
//            painter = painterResource(id = image),
//            contentDescription = null,
//            contentScale = ContentScale.FillWidth
//        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.width(180.dp),
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier.width(180.dp),
                text = description,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$price ₽",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}