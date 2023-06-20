package com.compose.medicine.smartlab.navigation

import android.content.Context
import androidx.navigation.NavController
import com.compose.medicine.smartlab.navigation.models.mappers.asDetails
import com.compose.medicine.smartlab.screens.analysis_details.presentation.AnalysisDetailsNavigation
import com.compose.medicine.smartlab.screens.analyzes.presentation.AnalysisNavigation
import com.compose.medicine.smartlab.screens.analyzes.presentation.models.AnalysisDetailsNavArg
import com.compose.medicine.smartlab.screens.authorization.presentation.AuthorizationScreenNavigation
import com.compose.medicine.smartlab.screens.basket.presentation.BasketNavigation
import com.compose.medicine.smartlab.screens.checkout.presentation.CheckoutNavigation
import com.compose.medicine.smartlab.screens.destinations.AnalysisDetailsScreenDestination
import com.compose.medicine.smartlab.screens.destinations.DateAndTimeScreenDestination
import com.compose.medicine.smartlab.screens.destinations.PatientChoiceScreenDestination
import com.compose.medicine.smartlab.screens.destinations.TestingAddressScreenDestination
import com.compose.medicine.smartlab.screens.onboard.presentation.OnBoardScreenNavigation
import com.compose.medicine.smartlab.screens.password.presentation.PasswordNavigation
import com.compose.medicine.smartlab.screens.patient_charts.presentation.PatientChartsNavigation
import com.compose.medicine.smartlab.screens.patient_choice.presentation.PatientChoiceNavigation
import com.compose.medicine.smartlab.screens.splash.presentation.SplashNavigation
import com.compose.medicine.smartlab.screens.testing_address.presentation.TestingAddressNavigation
import com.compose.medicine.smartlab.screens.verification.presentation.VerificationNavigation
import com.ramcosta.composedestinations.dynamic.within
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.NavGraphSpec

class CommonNavGraphNavigator(
    private val context: Context,
    private val navGraph: NavGraphSpec,
    private val navController: NavController
) : OnBoardScreenNavigation, AuthorizationScreenNavigation, VerificationNavigation,
    PasswordNavigation, PatientChartsNavigation, AnalysisDetailsNavigation, AnalysisNavigation,
    BasketNavigation, CheckoutNavigation, TestingAddressNavigation, PatientChoiceNavigation,
    SplashNavigation {
    override fun navigateToSignIn() {
        navController.navigate(NavGraphs.authorization)
    }

    override fun navigateToVerificationScreen() {
        navController.navigate(NavGraphs.verification)
    }

    override fun navigateBack() {
        navController.navigateUp()
    }

    override fun navigateToCheckoutScreen() {
        navController.navigate(NavGraphs.checkout)
    }

    override fun navigateToPasswordScreen() {
        navController.navigate(NavGraphs.password)
    }

    override fun navigateToPatientChartsScreen() {
        navController.navigate(NavGraphs.patient_chart)
    }

    override fun navigateToPatientChoiceScreen() {
        navController.navigate(PatientChoiceScreenDestination within navGraph)
    }

    override fun navigateToAnalyzesScreen() {
        navController.navigate(NavGraphs.analyzes)
    }

    override fun openAnalysisDetails(analysisDetailsNavArg: AnalysisDetailsNavArg) {
        navController.navigate(AnalysisDetailsScreenDestination(analysisDetails = analysisDetailsNavArg.asDetails()) within navGraph)
    }

    override fun navigateToBasketScreen() {
        navController.navigate(NavGraphs.basket)
    }

    override fun navigateToTestingAddressScreen() {
        navController.navigate(TestingAddressScreenDestination within navGraph)
    }

    override fun navigateToDateAndTimeScreen() {
        navController.navigate(DateAndTimeScreenDestination within navGraph)
    }

    override fun navigateToOnboardScreen() {
        navController.navigate(NavGraphs.onboard)
    }
}