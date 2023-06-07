package com.compose.medicine.smartlab.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.compose.medicine.smartlab.core_ui.currentBottomItemToState
import com.compose.medicine.smartlab.navigation.NavGraphs
import com.ramcosta.composedestinations.navigation.navigate

@Composable
fun AppHost() {
    val navController = rememberNavController()
    val visibleEntries by navController.visibleEntries.collectAsState()
    val isBottomNavigationBarVisible = visibleEntries.any { entry ->
        BottomBarDestination.values()
            .any { bottomBarDestination -> bottomBarDestination.direction.startRoute.route == entry.destination.route }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFFCFCFE),
        bottomBar = {
            AnimatedVisibility(
                visible = isBottomNavigationBarVisible,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it })
            ) {
                val currentDestination by navController.currentBottomItemToState()
                BottomNavigationBar(
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
            startRoute = NavGraphs.analyzes
        )
    }
}