package com.compose.medicine.smartlab.screens.patient_charts.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.medicine.smartlab.api.data.MedicRepository
import com.compose.medicine.smartlab.api.data.remote.models.PatientModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientChartsViewModel @Inject constructor(private val repository: MedicRepository) :
    ViewModel() {

    private val _state = MutableStateFlow(PatientChartsUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PatientChartsEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: PatientChartsUiEvent) {
        when (event) {
            is PatientChartsUiEvent.OnNavigateSkip -> {
                viewModelScope.launch {
                    _effect.emit(PatientChartsEffect.NavigateSkip)
                }
            }

            is PatientChartsUiEvent.OnNavigateToAnalyzes -> {
                checkFillAllField()
            }

            is PatientChartsUiEvent.OnNameInput -> {
                viewModelScope.launch {
                    _state.update { state ->
                        if (event.name.isEmpty()) {
                            state.copy(name = event.name, isEnabled = false, isError = true)
                        } else {
                            state.copy(name = event.name, isEnabled = true, isError = false)
                        }
                    }
                }
            }

            is PatientChartsUiEvent.OnLastNameInput -> {
                viewModelScope.launch {
                    _state.update { state ->
                        if (event.lastName.isEmpty()) {
                            state.copy(lastName = event.lastName, isEnabled = false, isError = true)
                        } else {
                            state.copy(lastName = event.lastName, isEnabled = true, isError = false)
                        }
                    }
                }
            }

            is PatientChartsUiEvent.OnPatronymicInput -> {
                viewModelScope.launch {
                    _state.update { state ->
                        if (event.patronymic.isEmpty()) {
                            state.copy(
                                patronymic = event.patronymic,
                                isEnabled = false,
                                isError = true
                            )
                        } else {
                            state.copy(
                                patronymic = event.patronymic,
                                isEnabled = true,
                                isError = false
                            )
                        }
                    }
                }
            }

            is PatientChartsUiEvent.OnBirthdateInput -> {
                viewModelScope.launch {
                    _state.update { state ->
                        if (event.birthdate.isEmpty()) {

                            state.copy(
                                birthdate = event.birthdate,
                                isEnabled = false,
                                isError = true
                            )
                        } else {
                            state.copy(
                                birthdate = event.birthdate,
                                isEnabled = true,
                                isError = false
                            )
                        }
                    }
                }
            }

            is PatientChartsUiEvent.OnGenderInput -> {
                viewModelScope.launch {
                    _state.update { state ->
                        if (event.gender.isEmpty()) {
                            state.copy(
                                gender = event.gender,
                                isEnabled = false,
                                isError = true
                            )
                        } else {
                            state.copy(
                                gender = event.gender,
                                isEnabled = true,
                                isError = false
                            )
                        }
                    }
                }
            }

            is PatientChartsUiEvent.OnLabelInput -> {
                viewModelScope.launch {
                    _state.update { state ->
                        if (event.label.isEmpty()) {
                            state.copy(
                                label = event.label,
                                isEnabled = false,
                                isError = true
                            )
                        } else {
                            state.copy(
                                label = event.label,
                                isEnabled = true,
                                isError = false
                            )
                        }
                    }
                }
            }
        }
    }

    private fun checkFillAllField() {
        if (_state.value.name.isEmpty() &&
            _state.value.lastName.isEmpty() &&
            _state.value.patronymic.isEmpty() &&
            _state.value.birthdate.isEmpty()
        ) {
            _state.update {
                it.copy(
                    isError = true,
                    isEnabled = false
                )
            }
        } else {
            viewModelScope.launch {
                repository.createPatient(
                    patient = PatientModel(
                        first_name = _state.value.name,
                        last_name = _state.value.lastName,
                        middle_name = _state.value.patronymic,
                        date_of_birth = _state.value.birthdate,
                        pol = _state.value.gender
                    )
                )
                _state.update {
                    it.copy(
                        isError = false,
                        isEnabled = true
                    )
                }
                _effect.emit(PatientChartsEffect.NavigateToAnalyzes)
            }
        }
    }
}


