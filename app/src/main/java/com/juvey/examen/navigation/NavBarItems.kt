package com.juvey.examen.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chair
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.WarningAmber

val NavBarItems = listOf(
    BarItem(
        title = "Primer",
        image = Icons.Filled.Chair,
        route = Routes.firstPartialView
    ),
    BarItem(
        title = "Segundo",
        image = Icons.Filled.WarningAmber,
        route = Routes.secondPartialView
    ),
    BarItem(
        title = "Tercero",
        image = Icons.Filled.Face,
        route = Routes.thirdPartialView
    ),
)
