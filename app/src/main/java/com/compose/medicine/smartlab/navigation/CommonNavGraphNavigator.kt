package com.compose.medicine.smartlab.navigation

import android.content.Context
import androidx.navigation.NavController
import com.compose.medicine.smartlab.screens.authorization.presentation.AuthorizationScreenNavigation
import com.compose.medicine.smartlab.screens.onboard.presentation.OnBoardScreenNavigation
import com.compose.medicine.smartlab.screens.password.presentation.PasswordNavigation
import com.compose.medicine.smartlab.screens.patient_charts.presentation.PatientChartsNavigation
import com.compose.medicine.smartlab.screens.verification.presentation.VerificationNavigation
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.NavGraphSpec

class CommonNavGraphNavigator(
    private val context: Context,
    private val navGraph: NavGraphSpec,
    private val navController: NavController
) : OnBoardScreenNavigation, AuthorizationScreenNavigation, VerificationNavigation,
    PasswordNavigation, PatientChartsNavigation {
    override fun navigateToSignIn() {
        navController.navigate(NavGraphs.authorization)
    }

    override fun navigateToVerificationScreen() {
        navController.navigate(NavGraphs.verification)
    }

    override fun navigateBack() {
        navController.navigateUp()
    }

    override fun navigateToPasswordScreen() {
        navController.navigate(NavGraphs.password)
    }

    override fun navigateToPatientCharts() {
        navController.navigate(NavGraphs.patient_chart)
    }

    override fun navigateToAnalyzesScreen() {
        navController.navigate(NavGraphs.analyzes)
    }
}