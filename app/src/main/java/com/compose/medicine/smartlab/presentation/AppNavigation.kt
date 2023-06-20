package com.compose.medicine.smartlab.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.compose.medicine.smartlab.core_ui.currentNavigator
import com.compose.medicine.smartlab.navigation.NavGraphs
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(
    navController: NavHostController,
//    startRoute: Route,
    modifier: Modifier = Modifier,
    bottomSheetNavigator: BottomSheetNavigator
) {
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = RoundedCornerShape(20.dp),
        sheetBackgroundColor = Color.White
    ) {
        DestinationsNavHost(
            modifier = modifier,
            navGraph = NavGraphs.root,
            navController = navController,
            engine = rememberAnimatedNavHostEngine(),
//            startRoute = startRoute,
            dependenciesContainerBuilder = { dependency(currentNavigator(LocalContext.current)) }
        )
    }
}