package com.compose.medicine.smartlab.screens.onboard.presentation.models

import com.compose.medicine.smartlab.R

sealed class OnBoardingPage(
    val buttonUp: Int,
    val title: Int,
    val description: Int,
    val image: Int
) {
    object First : OnBoardingPage (
        buttonUp = R.string.skip_button,
        title = R.string.analyzes,
        description = R.string.express_medicine,
        image = R.drawable.illustration
    )
    object Second : OnBoardingPage (
        buttonUp = R.string.skip_button,
        title = R.string.notifications,
        description = R.string.speed_results,
        image = R.drawable.second_onboard
    )

    object Third : OnBoardingPage (
        buttonUp = R.string.complete,
        title = R.string.monitoring,
        description = R.string.observation,
        image = R.drawable.third_on_board
    )
}