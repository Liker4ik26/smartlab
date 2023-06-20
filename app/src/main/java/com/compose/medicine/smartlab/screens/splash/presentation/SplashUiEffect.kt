package com.compose.medicine.smartlab.screens.splash.presentation

sealed class SplashUiEvent {
    object OnNavigateToOnboardScreen : SplashUiEvent()
}

sealed class SplashUiEffect {
    object NavigateToOnboardScreen : SplashUiEffect()
}