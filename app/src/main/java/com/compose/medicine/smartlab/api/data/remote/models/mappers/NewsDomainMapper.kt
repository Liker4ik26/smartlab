package com.compose.medicine.smartlab.api.data.remote.models.mappers

import com.compose.medicine.smartlab.api.data.remote.models.NewsResponse
import com.compose.medicine.smartlab.api.domain.NewsDomain

fun NewsResponse.toNewsDomain(): NewsDomain {
    return NewsDomain(
        id = id,
        name = name,
        description = description,
        price = price,
        image = image
    )
}