package com.juvey.examen.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chair
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.juvey.examen.R

@Composable
fun BottomNavBarView(navController: NavController) {
    BottomAppBar(containerColor = Color.Black) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        // Creación de la lista NavBarItems dentro del Composable
        val navItems = listOf(
            BarItem(
                title = stringResource(id = R.string.nav_first_title),
                image = Icons.Filled.Chair,
                route = Routes.firstPartialView
            ),
            BarItem(
                title = stringResource(id = R.string.nsv_second_title),
                image = Icons.Filled.WarningAmber,
                route = Routes.secondPartialView
            ),
            BarItem(
                title = stringResource(id = R.string.nav_third_title),
                image = Icons.Filled.Face,
                route = Routes.thirdPartialView
            ),
        )

        navItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = navItem.title,
                        tint = Color.White
                    )
                },
                label = {
                    Text(
                        text = navItem.title,
                        color = Color.White
                    )
                }
            )
        }
    }
}
