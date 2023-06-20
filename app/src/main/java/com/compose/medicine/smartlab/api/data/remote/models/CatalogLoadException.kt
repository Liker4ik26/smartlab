package com.compose.medicine.smartlab.api.data.remote.models

import com.compose.medicine.smartlab.core.ErrorReason

class CatalogLoadException(val reason: ErrorReason) : Exception()