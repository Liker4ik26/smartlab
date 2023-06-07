package com.compose.medicine.smartlab.presentation

import androidx.annotation.DrawableRes
import com.compose.medicine.smartlab.R
import com.compose.medicine.smartlab.navigation.NavGraphs.analyzes
import com.compose.medicine.smartlab.navigation.NavGraphs.profile
import com.ramcosta.composedestinations.spec.NavGraphSpec

enum class BottomBarDestination(
    val direction: NavGraphSpec,
    val label: String,
    @DrawableRes val icon: Int
) {
    Analyzes(
        direction = analyzes,
        label = "Анализы",
        icon =  R.drawable.analyzes
    ),
    Profile(
        direction = profile,
        label = "Профиль",
        icon = R. drawable.user
    )
}