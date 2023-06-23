package com.compose.medicine.smartlab.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.plusAssign
import com.compose.medicine.smartlab.core_ui.currentBottomItemToState
import com.compose.medicine.smartlab.navigation.NavGraphs
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.navigation.navigate

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@Composable
fun AppHost() {
    val navController = rememberAnimatedNavController()
    val visibleEntries by navController.visibleEntries.collectAsState()
    val isBottomNavigationBarVisible = visibleEntries.any { entry ->
        BottomBarDestination.values()
            .any { bottomBarDestination -> bottomBarDestination.direction.startRoute.route == entry.destination.route }
    }
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0.dp),
        containerColor = Color(0xFFFCFCFE),
        bottomBar = {
            AnimatedVisibility(
                visible = isBottomNavigationBarVisible,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it })
            ) {
                val currentDestination by navController.currentBottomItemToState()
                BottomNavigationBar(
                    modifier = Modifier.height(76.dp),
                    selectedNavigation = currentDestination,
                    onNavigationSelected = { selected ->
                        navController.navigate(selected) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                    },
                )
            }
        }
    ) { paddingValues ->
        AppNavigation(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startRoute = NavGraphs.analyzes,
            bottomSheetNavigator = bottomSheetNavigator
        )
    }
}