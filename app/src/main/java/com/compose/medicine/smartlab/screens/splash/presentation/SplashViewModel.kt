package com.compose.medicine.smartlab.screens.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _effect = MutableSharedFlow<SplashUiEffect>()
    val effect = _effect.asSharedFlow()

    init {
        viewModelScope.launch {
            sendEvent(SplashUiEvent.OnNavigateToOnboardScreen)
        }
    }

    fun sendEvent(event: SplashUiEvent) {
        when (event) {
            is SplashUiEvent.OnNavigateToOnboardScreen -> {
                viewModelScope.launch {
                    delay(2000)
                    _effect.emit(SplashUiEffect.NavigateToOnboardScreen)
                }
            }
        }
    }
}