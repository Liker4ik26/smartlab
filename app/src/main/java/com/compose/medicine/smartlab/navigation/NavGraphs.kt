package com.compose.medicine.smartlab.navigation

import com.compose.medicine.smartlab.screens.destinations.AnalysisDetailsScreenDestination
import com.compose.medicine.smartlab.screens.destinations.AnalyzesScreenDestination
import com.compose.medicine.smartlab.screens.destinations.AuthorizationScreenDestination
import com.compose.medicine.smartlab.screens.destinations.BasketScreenDestination
import com.compose.medicine.smartlab.screens.destinations.CheckoutScreenDestination
import com.compose.medicine.smartlab.screens.destinations.DateAndTimeScreenDestination
import com.compose.medicine.smartlab.screens.destinations.PasswordScreenDestination
import com.compose.medicine.smartlab.screens.destinations.PatientChartsScreenDestination
import com.compose.medicine.smartlab.screens.destinations.PatientChoiceScreenDestination
import com.compose.medicine.smartlab.screens.destinations.SplashScreenDestination
import com.compose.medicine.smartlab.screens.destinations.SuccessfulPaymentScreenDestination
import com.compose.medicine.smartlab.screens.destinations.TestingAddressScreenDestination
import com.compose.medicine.smartlab.screens.destinations.UserProfileScreenDestination
import com.compose.medicine.smartlab.screens.destinations.VerificationScreenDestination
import com.compose.medicine.smartlab.screens.destinations.WelcomeScreenDestination
import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object NavGraphs {
    val analyzes = object : NavGraphSpec {
        override val route = "analyzes"
        override val startRoute = AnalyzesScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            AnalyzesScreenDestination,
            BasketScreenDestination,
            AnalysisDetailsScreenDestination
        ).routedIn(this).associateBy { it.route }
    }
    val profile = object : NavGraphSpec {
        override val route = "profile"
        override val startRoute = UserProfileScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            UserProfileScreenDestination
        ).routedIn(this).associateBy { it.route }
    }
    val onboard = object : NavGraphSpec {
        override val route = "onboard"
        override val startRoute = WelcomeScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            WelcomeScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val authorization = object : NavGraphSpec {
        override val route = "authorization"
        override val startRoute = AuthorizationScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            AuthorizationScreenDestination
        ).routedIn(this).associateBy { it.route }
    }
    val verification = object : NavGraphSpec {
        override val route = "verification"
        override val startRoute = VerificationScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            VerificationScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val password = object : NavGraphSpec {
        override val route = "password"
        override val startRoute = PasswordScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            PasswordScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val patient_chart = object : NavGraphSpec {
        override val route = "patient_chart"
        override val startRoute = PatientChartsScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            PatientChartsScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val basket = object : NavGraphSpec {
        override val route = "basket"
        override val startRoute = BasketScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            BasketScreenDestination
        ).routedIn(this).associateBy { it.route }
    }
    val checkout = object : NavGraphSpec {
        override val route = "checkout"
        override val startRoute = CheckoutScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            CheckoutScreenDestination,
            TestingAddressScreenDestination,
            DateAndTimeScreenDestination,
            PatientChoiceScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val splash = object : NavGraphSpec {
        override val route = "splash"
        override val startRoute = SplashScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            SplashScreenDestination,
            WelcomeScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val successful_payments = object : NavGraphSpec {
        override val route = "successful_payments"
        override val startRoute = SuccessfulPaymentScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            SuccessfulPaymentScreenDestination,
        ).routedIn(this).associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route = "root"
        override val startRoute = splash
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
        override val nestedNavGraphs = listOf(
            splash,
            analyzes,
            onboard,
            profile,
            authorization,
            verification,
            password,
            patient_chart,
            basket,
            checkout,
            successful_payments
        )
    }
}