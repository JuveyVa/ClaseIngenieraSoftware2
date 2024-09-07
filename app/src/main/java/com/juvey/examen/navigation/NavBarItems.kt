package com.juvey.examen.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chair
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.juvey.examen.R

@Composable
fun NavBarItems() {
    val context = LocalContext.current
    val navItems = listOf(
        BarItem(
            title = context.getString(R.string.nav_first_title),
            image = Icons.Filled.Chair,
            route = Routes.firstPartialView
        ),
        BarItem(
            title = context.getString(R.string.nsv_second_title),
            image = Icons.Filled.WarningAmber,
            route = Routes.secondPartialView
        ),
        BarItem(
            title = context.getString(R.string.nav_third_title),
            image = Icons.Filled.Face,
            route = Routes.thirdPartialView
        ),
    )
}
