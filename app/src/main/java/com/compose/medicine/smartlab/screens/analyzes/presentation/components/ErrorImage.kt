package com.compose.medicine.smartlab.screens.analyzes.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.compose.medicine.smartlab.R

@Composable
fun ErrorImage(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Icon(
            imageVector = Icons.Outlined.Close,
            contentDescription = stringResource(R.string.error_image),
            modifier = Modifier
                .align(Alignment.Center)
                .size(64.dp)
        )
    }
}