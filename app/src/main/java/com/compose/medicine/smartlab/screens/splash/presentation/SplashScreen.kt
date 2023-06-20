package com.compose.medicine.smartlab.screens.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.medicine.smartlab.R
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun SplashScreen(navigation: SplashNavigation) {
    SplashScreen(onNavigateToOnboardScreen = navigation::navigateToOnboardScreen)
}

@Composable
private fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToOnboardScreen: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is SplashUiEffect.NavigateToOnboardScreen -> onNavigateToOnboardScreen()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splash),
            contentDescription = null
        )
    }
}