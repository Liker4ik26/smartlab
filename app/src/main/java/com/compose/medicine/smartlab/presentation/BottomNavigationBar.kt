package com.compose.medicine.smartlab.presentation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.ramcosta.composedestinations.spec.NavGraphSpec

@Composable
fun BottomNavigationBar(
    selectedNavigation: NavGraphSpec,
    onNavigationSelected: (NavGraphSpec) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.White
    ) {
        BottomBarDestination.values().forEach { destination ->
            NavigationBarItem(
                selected = selectedNavigation == destination.direction,
                onClick = { onNavigationSelected(destination.direction) },
                label = {
                    Text(
                        text = destination.label,
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = destination.icon),
                        contentDescription = null
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedIconColor = Color(0xFFB8C1CC),
                    unselectedTextColor = Color(0xFFB8C1CC),
                    selectedTextColor = Color(0xFF1A6FEE),
                    selectedIconColor = Color(0xFF1A6FEE),
                    indicatorColor = Color(0xFFFFFF)
                )
            )
        }
    }
}