package com.compose.medicine.smartlab.screens.authorization.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(AuthorizationUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<AuthorizationEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: AuthorizationUiEvent) {
        when (event) {
            is AuthorizationUiEvent.OnNavigateToVerificationScreen -> {
                checkAuthorizedStatus()
            }

            is AuthorizationUiEvent.OnEmailInput -> {
                viewModelScope.launch {
                    _state.update { state ->
                        if (event.email.isEmpty()) {
                            state.copy(email = event.email, isEnabled = false, isError = true)
                        } else {
                            state.copy(email = event.email, isEnabled = true, isError = false)
                        }
                    }
                }
            }
        }
    }

    private fun checkAuthorizedStatus() {
        if (checkEmail(_state.value.email)) {
            viewModelScope.launch {
                _state.update {
                    it.copy(
                        isError = false,
                        isEnabled = true
                    )
                }
                _effect.emit(AuthorizationEffect.NavigateToVerificationScreen)
            }
        } else {
            _state.update {
                it.copy(
                    isError = true,
                    isEnabled = false
                )
            }
        }
    }
}

val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
)

private fun checkEmail(email: String): Boolean {
    return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
}