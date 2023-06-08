package com.compose.medicine.smartlab.screens.onboard.presentation

sealed class OnBoardUiEvent {
    object OnNavigateToSignIn : OnBoardUiEvent()
}

sealed class OnBoardUiEffect {
    object NavigateToSignIn : OnBoardUiEffect()
}