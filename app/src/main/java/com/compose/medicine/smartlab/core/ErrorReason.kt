package com.compose.medicine.smartlab.core

sealed class ErrorReason {
    abstract val details: String

    class NotFound(
        override val details: String
    ) : ErrorReason()

    class ServerError(
        override val details: String
    ) : ErrorReason()

    data class NetworkError(val throwable: Throwable) : ErrorReason() {
        override val details: String = throwable.localizedMessage.orEmpty()
    }

    data class UnexpectedError(val throwable: Throwable) : ErrorReason() {
        override val details: String = throwable.localizedMessage.orEmpty()
    }
}