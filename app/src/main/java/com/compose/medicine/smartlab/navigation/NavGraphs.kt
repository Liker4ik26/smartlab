package com.compose.medicine.smartlab.navigation

import com.compose.medicine.smartlab.screens.destinations.AnalyzesScreenDestination
import com.compose.medicine.smartlab.screens.destinations.UserProfileScreenDestination
import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object NavGraphs {
    val analyzes = object : NavGraphSpec {
        override val route = "analyzes"
        override val startRoute = AnalyzesScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            AnalyzesScreenDestination
        ).routedIn(this).associateBy { it.route }
    }
    val profile = object : NavGraphSpec {
        override val route = "profile"
        override val startRoute = UserProfileScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            UserProfileScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route = "route"
        override val startRoute = analyzes
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
        override val nestedNavGraphs = listOf(
            analyzes, profile
        )
    }
}