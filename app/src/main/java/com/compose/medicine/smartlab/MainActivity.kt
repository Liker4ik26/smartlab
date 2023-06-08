package com.compose.medicine.smartlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.compose.medicine.smartlab.screens.password.presentation.PasswordScreen
import com.compose.medicine.smartlab.screens.password.presentation.components.PinManager
import com.compose.medicine.smartlab.ui.theme.SmartlabTheme
import dagger.hilt.android.AndroidEntryPoint
import com.compose.medicine.smartlab.presentation.AppHost

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PinManager.initialize(this)
            SmartlabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppHost()
                }
            }
        }
    }
}