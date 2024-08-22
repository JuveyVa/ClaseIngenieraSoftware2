package com.juvey.examen.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call

val NavBarItems = listOf(
    BarItem(
        title = "Primer",
        image = Icons.Filled.AccountBox,
        route = Routes.firstPartialView
    ),
    BarItem(
        title = "Segundo",
        image = Icons.Filled.AddCircle,
        route = Routes.secondPartialView
    ),
    BarItem(
        title = "Tercero",
        image = Icons.Filled.Call,
        route = Routes.thirdPartialView
    ),
)
