package com.compose.medicine.smartlab.screens.successful_payment.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class SuccessfulPaymentScreenUiState(
    val isLoading: Boolean = true
) {
    companion object {
        val Empty = SuccessfulPaymentScreenUiState()
    }
}
