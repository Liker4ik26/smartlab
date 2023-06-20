package com.compose.medicine.smartlab.screens.testing_address.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestingAddressViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(TestingAddressUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<TestingAddressUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: TestingAddressUiEvent) {
        when (event) {
            is TestingAddressUiEvent.OnAddressInput -> {
                _state.update { state ->
                    if (event.address.isNotEmpty()) {
                        state.copy(address = event.address, isError = false, isEnabled = true)
                    } else {
                        state.copy(address = event.address, isError = true, isEnabled = false)
                    }
                }
            }

            is TestingAddressUiEvent.OnLongitudeInput -> {
                _state.update { state ->
                    if (event.longitude.isNotEmpty() && isNumeric(event.longitude)) {
                        state.copy(
                            longitude = event.longitude,
                            isError = false,
                            isEnabled = true
                        )
                    } else {
                        state.copy(
                            longitude = event.longitude,
                            isError = true,
                            isEnabled = false
                        )
                    }
                }

            }

            is TestingAddressUiEvent.OnLatitudeInput -> {
                _state.update { state ->
                    if (event.latitude.isNotEmpty() && isNumeric(event.latitude)) {
                        state.copy(
                            latitude = event.latitude,
                            isError = false,
                            isEnabled = true
                        )
                    } else {
                        state.copy(
                            latitude = event.latitude,
                            isError = true,
                            isEnabled = false
                        )
                    }
                }

            }

            is TestingAddressUiEvent.OnHeightInput -> {
                _state.update { state ->
                    if (event.height.isNotEmpty() && isNumeric(event.height)) {
                        state.copy(
                            height = event.height,
                            isError = false,
                            isEnabled = true
                        )
                    } else {
                        state.copy(
                            height = event.height,
                            isError = true,
                            isEnabled = false
                        )
                    }
                }
            }

            is TestingAddressUiEvent.OnEntranceInput -> {
                _state.update { state ->
                    if (event.entrance.isNotEmpty() && isNumeric(event.entrance)) {
                        state.copy(
                            entrance = event.entrance,
                            isError = false,
                            isEnabled = true
                        )
                    } else {
                        state.copy(
                            entrance = event.entrance,
                            isError = true,
                            isEnabled = false
                        )
                    }
                }

            }

            is TestingAddressUiEvent.OnFloorInput -> {

                _state.update { state ->
                    if (event.floor.isNotEmpty() && isNumeric(event.floor)) {
                        state.copy(
                            floor = event.floor,
                            isError = false,
                            isEnabled = true
                        )
                    } else {
                        state.copy(
                            floor = event.floor,
                            isError = true,
                            isEnabled = false
                        )
                    }
                }

            }

            is TestingAddressUiEvent.OnIntercomInput -> {
                _state.update { state ->
                    if (event.intercom.isNotEmpty()) {
                        state.copy(intercom = event.intercom, isError = false, isEnabled = true)
                    } else {
                        state.copy(intercom = event.intercom, isError = true, isEnabled = false)
                    }
                }

            }

            is TestingAddressUiEvent.OnApartmentInput -> {
                _state.update { state ->
                    if (event.apartment.isNotEmpty() && isNumeric(event.apartment)) {
                        state.copy(
                            apartment = event.apartment,
                            isError = false,
                            isEnabled = true
                        )
                    } else {
                        state.copy(
                            apartment = event.apartment,
                            isError = true,
                            isEnabled = false
                        )
                    }
                }

            }

            is TestingAddressUiEvent.OnNavigateBack -> {
                viewModelScope.launch {
                    checkFillAllField()
                }
            }
        }
    }

    private fun checkFillAllField() {
        if (_state.value.address.isEmpty() ||
            _state.value.latitude.isEmpty() ||
            _state.value.longitude.isEmpty() ||
            _state.value.floor.isEmpty() ||
            _state.value.entrance.isEmpty() ||
            _state.value.intercom.isEmpty() ||
            _state.value.height.isEmpty() ||
            _state.value.apartment.isEmpty()
        ) {
            _state.update {
                it.copy(
                    isError = true,
                    isEnabled = false
                )
            }
        } else {
            viewModelScope.launch {
                _effect.emit(TestingAddressUiEffect.NavigateBack)
                _state.update {
                    it.copy(
                        isError = false,
                        isEnabled = true
                    )
                }

            }
        }
    }

    fun isNumeric(str: String): Boolean = str
        .removePrefix("-")
        .removePrefix("+")
        .all { it in '0'..'9' }
}