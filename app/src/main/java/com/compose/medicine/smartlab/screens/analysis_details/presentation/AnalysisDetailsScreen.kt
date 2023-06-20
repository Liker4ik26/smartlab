package com.compose.medicine.smartlab.screens.analysis_details.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.medicine.smartlab.screens.analysis_details.presentation.components.AnalysisDetails
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(
    navArgsDelegate = AnalysisDetailsNavArgs::class,
    style = DestinationStyle.BottomSheet::class
)
@Composable
fun AnalysisDetailsScreen(
    navigation: AnalysisDetailsNavigation
) {
    AnalysisDetailsScreen(onBack = navigation::navigateBack)
}

@Composable
private fun AnalysisDetailsScreen(
    viewModel: AnalysisDetailsViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                AnalysisDetailsUiEffect.NavigateBack -> onBack()
            }
        }
    }
    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .background(Color.White)
    ) {
        AnalysisDetails(
            title = state.title?.asString(),
            description = state.description?.asString(),
            preparation = state.preparation?.asString(),
            result = state.timeResult,
            biomaterial = state.biomaterial,
            price = state.price
        ) {
            viewModel.sendEvent(AnalysisDetailsUiEvent.onBack)
        }
    }
}